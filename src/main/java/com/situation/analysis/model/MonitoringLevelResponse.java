package com.situation.analysis.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: Level
 * @author: Kobe
 * @date: 2021/3/9 下午9:35
 * @version: v1.0
 */
@Data
public class MonitoringLevelResponse {
    private int id;
    private String name;
    private BigDecimal impactedFactor;
    private int objectId;
    private String instruction;
}
