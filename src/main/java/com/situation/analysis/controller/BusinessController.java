package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.exception.BizException;
import com.situation.analysis.model.PageRequest;
import com.situation.analysis.model.PageResult;
import com.situation.analysis.entity.MonitoringLevel;
import com.situation.analysis.service.AOService;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoResult;
import com.situation.analysis.webservices.expenses.ExpensesResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: business
 * @author: Kobe
 * @date: 2021/2/15 下午4:51
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
public class BusinessController {
    @Resource
    private AOService aoService;

    @GetMapping("/expenses")
    public ExpensesResult searchExpenses(@RequestParam String empId) {
        log.debug("search empId is : {}",empId);
        return aoService.searchExpensesService(empId);
    }

    @GetMapping("/expenses")
    public ReadExpenseinfoResult readExpenseInfo(@RequestParam String orderId, @RequestParam String orderNum,@RequestParam String empId) {
        log.debug("read expense info orderId is: {}, orderNum is : {}, empId is : {}",orderId, orderNum, empId);
        return aoService.readExpenseInfo(orderId,orderNum,empId);
    }


}
