package com.situation.analysis.entity;

import lombok.Data;


/**
 * @description: 指标
 * @author: Kobe
 * @date: 2021/3/9 下午8:08
 * @version: v1.0
 */
@Data
public class IndicatorEntity implements Serializable {
    private int id;
    private String name;
    private float impactFactor;
    private int objectId;
    private String instruction;
    private String isOriginalValue;
    private String createdBy;
    private String createdTime;
    private String updatedBy;
    private String updatedTime;
}
