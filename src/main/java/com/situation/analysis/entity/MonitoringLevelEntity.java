package com.situation.analysis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 检测层次
 * @author: Kobe
 * @date: 2021/2/15 下午4:44
 * @version: v1.0
 */
@Data
public class MonitoringLevelEntity implements Serializable {
    private int id;
    private String name;
    private float impactFactor;
    private int runThreshold;
    private String createdBy;
    private String createdTime;
    private String updatedBy;
    private String updatedTime;
}
