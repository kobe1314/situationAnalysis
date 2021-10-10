package com.situation.analysis.service.impl;

import com.alibaba.fastjson.JSON;
import com.jayway.jsonpath.JsonPath;
import com.situation.analysis.model.CompareData;
import com.situation.analysis.model.DetailsDTO;
import com.situation.analysis.service.AOService;
import com.situation.analysis.service.BusinessService;
import com.situation.analysis.service.OCRService;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoResult;
import com.situation.analysis.webservices.expenseinfo.ReadExpensesDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: business service impl
 * @author: Kobe
 * @date: 2021/10/9 下午1:59
 * @version: v1.0
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private OCRService ocrService;

    @Resource
    private AOService aoService;

    @Override
    public Object deliveryTicket(MultipartFile file, String orderId, String orderNum, String empId) throws IOException {
        log.debug("come in delivery ticket service");

        String json = ocrService.get_multiple_items_info(file);
        List<DetailsDTO> list = getResult(json);


        ReadExpenseinfoResult info = aoService.readExpenseInfo(orderId, orderNum, empId);
        List<ReadExpensesDetail> atreturn = info.getATRETURN();

        List<CompareData> compareDataList = new ArrayList<>();

        list.forEach(ocrDetail -> {
            CompareData compareData = new CompareData();
            compareData.setOcrDetail(ocrDetail);
            String code = ocrDetail.getCode();
            String number = ocrDetail.getNumber();
            String total = ocrDetail.getTotal();
            findRecord4OCR(code,number,total,atreturn,compareDataList,compareData);
            compareDataList.add(compareData);
        });


        atreturn.forEach(detail -> {
            String code = detail.getINVOICECODE();
            String number = detail.getINVOICENUMBER();
            String amount = String.valueOf(detail.getAMOUNT());
            findRecord(code,number,amount,list,compareDataList,detail);
        });


        return compareDataList;
    }
    
    private void findRecord4OCR(String code,String number,String total, List<ReadExpensesDetail> atreturn, List<CompareData> compareDataList,CompareData compareData ) {

        atreturn.forEach(detail -> {
            // 合并相同的记录
            if(code.equals(detail.getINVOICECODE()) && number.equals(detail.getINVOICENUMBER())) {
                compareData.setExpensesDetail(detail);
                compareData.setEqualInvoiceCode(true);
                compareData.setEqualInvoiceNum(true);
                if(total.equals(String.valueOf(detail.getAMOUNT()))) {
                    compareData.setEqualInvoiceMon(true);
                } else {
                    compareData.setEqualInvoiceMon(false);
                }
            } else {
                compareData.setEqualInvoiceCode(false);
                compareData.setEqualInvoiceNum(false);
                compareData.setEqualInvoiceMon(false);
            }
        });

    }

    private void findRecord(String code,String number, String total, List<DetailsDTO> list, List<CompareData> compareDataList,ReadExpensesDetail detail ) {

        list.forEach(ocrDetail -> {
            // 去除掉相同的记录
            if(!code.equals(ocrDetail.getCode()) || !number.equals(ocrDetail.getNumber())) {
                CompareData compareData = new CompareData();
                compareData.setExpensesDetail(detail);
                compareData.setEqualInvoiceCode(false);
                compareData.setEqualInvoiceNum(false);
                compareData.setEqualInvoiceMon(false);
                compareDataList.add(compareData);

            }
        });

    }

    private List<DetailsDTO> getResult(String json) {
        List<DetailsDTO> list = null;
        String values = JsonPath.read(json, "$.response.data.identify_results[*].details").toString();
        if (!ObjectUtils.isEmpty(values)) {
            list = JSON.parseArray(values, DetailsDTO.class);
        }
        return list;
    }

    //private List<IdentifyResult> getResult(String json) {
    //    List<IdentifyResult> list = null;
    //    String values = JsonPath.read(json, "$.response.data.identify_results").toString();
    //    if (!ObjectUtils.isEmpty(values)) {
    //        list = JSON.parseArray(values, IdentifyResult.class);
    //    }
    //    return list;
    //}
}
