package com.situation.analysis.service.impl;

import com.situation.analysis.service.AOService;
import com.situation.analysis.webservices.error.SendExpenseErrorService;
import com.situation.analysis.webservices.error.SendExpenseResult;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoResult;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoService;
import com.situation.analysis.webservices.expenses.ExpensesResult;
import com.situation.analysis.webservices.expenses.SearchExpensesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: AO implement
 * @author: Kobe
 * @date: 2021/10/6 上午10:41
 * @version: v1.0
 */
@Slf4j
@Service
public class AOServiceImpl implements AOService {

    @Resource
    private SearchExpensesService searchExpensesService;

    @Resource
    private ReadExpenseinfoService readExpenseinfoService;

    @Resource
    private SendExpenseErrorService sendExpenseErrorService;

    @Override
    public ExpensesResult searchExpensesService(String empId) {
        log.debug("come in searchExpensesService");
        return searchExpensesService.searchExpenses(empId);
    }

    @Override
    public ReadExpenseinfoResult readExpenseInfo(String orderId, String orderNum,String empId) {
        log.debug("come in readExpenseInfo");
        return readExpenseinfoService.readExpenseinfo(orderId,orderNum,empId);
    }

    @Override
    public SendExpenseResult sendExpenseError() {
        log.debug("come in sendExpenseError");
        return null;
    }
}
