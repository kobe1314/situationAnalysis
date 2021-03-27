package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description: business info
 * @author: Kobe
 * @date: 2021/3/13 下午5:33
 * @version: v1.0
 */
@Data
public class BusinessInfo {
    private int id;
    private String name;
    private String platform;
    private int runThreshold;
    private float impactFactor;
    private String isOriginalValue;
    private List<ObjectInfo> objectList;
}
