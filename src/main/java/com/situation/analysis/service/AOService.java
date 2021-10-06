package com.situation.analysis.service;

import com.situation.analysis.webservices.error.SendExpenseResult;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoResult;
import com.situation.analysis.webservices.expenses.ExpensesResult;

/**
 * @description: AO interface
 * @author: Kobe
 * @date: 2021/10/6 上午10:38
 * @version: v1.0
 */
public interface AOService {

    ExpensesResult searchExpensesService(String empId);

    ReadExpenseinfoResult readExpenseInfo(String orderID, String orderNum,String empId);

    SendExpenseResult sendExpenseError();
}
