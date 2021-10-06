package com.situation.analysis.config;

import com.situation.analysis.webservices.error.SendExpenseErrorService;
import com.situation.analysis.webservices.error.SendExpenseErrorServiceImplService;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfo;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoService;
import com.situation.analysis.webservices.expenseinfo.ReadExpenseinfoServiceImplService;
import com.situation.analysis.webservices.expenses.SearchExpensesService;
import com.situation.analysis.webservices.expenses.SearchExpensesServiceImplService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: config
 * @author: Kobe
 * @date: 2021/10/6 上午10:58
 * @version: v1.0
 */
@Configuration
public class Config {

    @Bean
    public SearchExpensesService searchExpensesService() {
        return new SearchExpensesServiceImplService().getSearchExpensesServiceImplPort();
    }

    @Bean
    public ReadExpenseinfoService readExpenseinfoService() {
        return new ReadExpenseinfoServiceImplService().getReadExpenseinfoServiceImplPort();
    }

    @Bean
    public SendExpenseErrorService sendExpenseErrorService() {
        return new SendExpenseErrorServiceImplService().getSendExpenseErrorServiceImplPort();
    }
}
