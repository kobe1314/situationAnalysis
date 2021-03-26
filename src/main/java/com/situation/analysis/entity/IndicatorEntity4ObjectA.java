package com.situation.analysis.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 指标
 * @author: Kobe
 * @date: 2021/3/9 下午8:08
 * @version: v1.0
 */
@Data
public class IndicatorEntity4ObjectA {
    private int id;
    private String diagTime;
    private String code;
    private String name;
    private float onlineRatingA11;
    private float connectRatingA12;
    private float delayRatingA13;
    private float exceptionRatingA14;
    private String createdBy;
    private String createdTime;
    private String updatedBy;
    private String updatedTime;
}
