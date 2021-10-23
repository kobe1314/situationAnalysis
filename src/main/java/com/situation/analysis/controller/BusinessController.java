package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.service.AOService;
import com.situation.analysis.service.BusinessService;
import com.situation.analysis.util.BaseLiuFile;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoResult;
import com.situation.analysis.webservices.expenses.ExpensesResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @description: businessØ
 * @author: Kobe≤
 * @date: 2021/2/15 下午4:51
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class BusinessController {
    @Resource
    private AOService aoService;
    @Resource
    private BusinessService businessService;

    @GetMapping("/expenses")
    public ExpensesResult searchExpenses(@RequestParam String empId) {
        log.debug("search empId is : {}",empId);
        return aoService.searchExpensesService(empId);
    }

    @GetMapping("/expense")
    public ReadExpenseinfoResult readExpenseInfo(@RequestParam String orderId, @RequestParam String orderNum,@RequestParam String empId) {
        log.debug("read expense info. orderId is: {}, orderNum is : {}, empId is : {}",orderId, orderNum, empId);
        return aoService.readExpenseInfo(orderId,orderNum,empId);
    }

    @PostMapping("/ticket")
    public Object deliveryTicket(@RequestParam("file") String file, @RequestParam String orderId, @RequestParam String orderNum, @RequestParam String empId) throws IOException {
        log.debug("delivery ticket info. orderId is: {}, orderNum is : {}, empId is : {}",orderId, orderNum, empId);
        MultipartFile multipartFilefile = BaseLiuFile.baseLiuToMultipart(file);
        return businessService.deliveryTicket(multipartFilefile,orderId,orderNum,empId);
    }

}
