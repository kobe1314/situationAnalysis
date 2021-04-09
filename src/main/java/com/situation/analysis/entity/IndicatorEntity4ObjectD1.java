package com.situation.analysis.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @description: 指标
 * @author: Kobe
 * @date: 2021/3/9 下午8:08
 * @version: v1.0
 */
@Data
@Builder
public class IndicatorEntity4ObjectD1 extends BasedEntity4Record {
    private float serviceConnectedRatingD11;
    private float serviceCompletedRatingD12;
    private float serviceUsingRatingD13;
    private float serviceDelayRatingD14;

}
