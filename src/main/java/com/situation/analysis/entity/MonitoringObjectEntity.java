package com.situation.analysis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 对象
 * @author: Kobe
 * @date: 2021/3/9 下午8:11
 * @version: v1.0
 */
@Data
public class MonitoringObjectEntity implements Serializable {
    private int id;
    private String name;
    private float impactFactor;
    private float businessImpactFactor;
    private int runThreshold;
    private int levelId;
    private int businessId;
    private String isOriginalValue;
    private String createdBy;
    private String createdTime;
    private String updatedBy;
    private String updatedTime;

}
