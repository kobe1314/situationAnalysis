package com.situation.analysis.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: Indicator
 * @author: Kobe
 * @date: 2021/3/9 下午8:18
 * @version: v1.0
 */
@Data
public class IndicatorResponse {
    private int id;
    private String name;
    private String instruction;
    //private BigDecimal impactedFactor;
    //private int objectId;
}
