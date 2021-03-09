package com.situation.analysis.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 检测层次
 * @author: Kobe
 * @date: 2021/2/15 下午4:44
 * @version: v1.0
 */
@Data
public class MonitoringLevelEntity {
    private int id;
    private String name;
    private BigDecimal impactFactor;
    private int runThreshold;
    private String createdBy;
    private String createdTime;
    private String updatedBy;
    private String updatedTime;
}
