package com.situation.analysis.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.entity.Employee;
import com.situation.analysis.entity.Logon;
import com.situation.analysis.exception.BizException;
import com.situation.analysis.model.LogonRequest;
import com.situation.analysis.service.EmployeeService;
import com.situation.analysis.service.LogonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: ValidateCodeController
 * @author: Kobe
 * @date: 2021/10/17 下午4:45
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
public class ValidateCodeController {

    private static String signName = "北京莱湾兴业科技有限公司";
    private static String product = "Dysmsapi";//短信API产品名称
    private static String domain = "dysmsapi.aliyuncs.com";//短信API产品域名
    private static String templateCode = "SMS_226270029";//短信API产品域名
    private static String accessKeyId = "LTAI5tPsj6xp1hquftzZZexn";//你的accessKeyId
    private static String accessKeySecret = "uuK6lilM21So1XDxiyXsETBjdEkbjS";//你的accessKeySecret

    @Resource
    private EmployeeService employeeService;

    @Resource
    private LogonService logonService;

    @GetMapping("/logonByCardId")
    public Employee logon(@RequestParam String cardId) {
        log.info("logon type is card, cardId is {}", cardId);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("CardId", cardId);
        Employee employee = employeeService.getOne(queryWrapper);
        return employee;
    }

    @PostMapping("/logon")
    public Employee logon(@RequestBody LogonRequest logonRequest) {
        int type = logonRequest.getType();
        log.info("logon type ", type);

        if (1 == logonRequest.getType()) {
            QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("CardId", logonRequest.getCardId());
            Employee employee = employeeService.getOne(queryWrapper);
            return employee;
        }

        if (2 == logonRequest.getType()) {
            QueryWrapper<Logon> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", logonRequest.getName());
            queryWrapper.eq("phone_number", logonRequest.getPhoneNumber());
            Logon logon = logonService.getOne(queryWrapper);
            if (!StringUtils.isEmpty(logonRequest.getCode()) && Long.valueOf(logon.getExpiredTime()) >= (System.currentTimeMillis() / 1000) && logonRequest.getCode().equals(logon.getCode())) {
                QueryWrapper<Employee> wrapper = new QueryWrapper<>();
                wrapper.eq("cnname", logonRequest.getName());
                wrapper.eq("phonenumber",logonRequest.getPhoneNumber());
                return employeeService.getOne(wrapper);

            }

        }
        throw new BizException("用户名或者密码不正确!");

    }

    @GetMapping("/code")
    public SendSmsResponse generatorValidationCode(@RequestParam String name, @RequestParam String phoneNum) throws ClientException {
        log.info("name is {}, phoneNum is {}", name, phoneNum);

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PHONENUMBER", phoneNum);
        queryWrapper.eq("CNNAME", name);
        Employee employee = employeeService.getOne(queryWrapper);

        if (null == employee) {
            throw new BizException("该用户不存在!");
        }

        SendSmsResponse response = sendSms(phoneNum);

        Logon logon = new Logon();
        logon.setPhoneNumber(phoneNum);
        logon.setName(name);
        logon.setCode(response.getCode());
        logon.setExpiredTime(String.valueOf(System.currentTimeMillis() / 1000 + 300));

        QueryWrapper<Logon> logonQueryWrapper = new QueryWrapper<>();
        logonQueryWrapper.eq("phone_number", phoneNum);
        logonService.saveOrUpdate(logon,logonQueryWrapper);

        return response;
    }


    private SendSmsResponse sendSms(String phoneNum) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        String[] codees = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String code = "";
        for (int i = 0; i < 6; i++) {
            int j = (int) (Math.random() * 10);
            code += codees[j];
        }

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            sendSmsResponse.setCode(code);
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return sendSmsResponse;
    }
}
