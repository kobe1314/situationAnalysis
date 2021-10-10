package com.situation.analysis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.situation.analysis.webservices.expenseinfo.ReadExpensesDetail;
import lombok.Data;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/10/10 下午3:31
 * @version: v1.0
 */
@Data
public class CompareData {
    private ReadExpensesDetail expensesDetail;
    private DetailsDTO ocrDetail;
    private boolean equalInvoiceNum;
    private boolean equalInvoiceCode;
    private boolean equalInvoiceMon;
}
