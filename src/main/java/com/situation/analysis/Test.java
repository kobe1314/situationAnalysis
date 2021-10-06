package com.situation.analysis;

import com.situation.analysis.webservices.expenses.ExpensesResult;
import com.situation.analysis.webservices.expenses.SearchExpensesServiceImplService;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/10/6 上午9:50
 * @version: v1.0
 */
public class Test {
    public static void main(String[] args) {

        SearchExpensesServiceImplService expensesServiceImplService = new SearchExpensesServiceImplService();
        ExpensesResult result = expensesServiceImplService.getSearchExpensesServiceImplPort().searchExpenses("A0045");
        System.out.println(result.toString());
    }
}
