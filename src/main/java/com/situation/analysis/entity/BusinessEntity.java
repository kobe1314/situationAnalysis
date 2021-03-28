package com.situation.analysis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: business
 * @author: Kobe
 * @date: 2021/3/13 下午3:07
 * @version: v1.0
 */
@Data
public class BusinessEntity implements Serializable {
    private int id;
    private String name;
    private float impactFactor;
    private String platform;
    private int runThreshold;
    private String isOriginalValue;
    private String createdBy;
    private String createdTime;
    private String updatedBy;
    private String updatedTime;
}
