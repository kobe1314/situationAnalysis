package com.situation.analysis.model;

import lombok.Data;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/3/9 下午10:21
 * @version: v1.0
 */
@Data
public class IndicatorInfo {
    private int id;
    private String name;
    private float impactFactor;
    private int objectId;
}
