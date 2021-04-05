package com.situation.analysis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: object info
 * @author: Kobe
 * @date: 2021/3/11 下午5:58
 * @version: v1.0
 */
@Data
public class ObjectInfo implements Serializable {
    private int id;
    private String objectName;
    private float impactFactor;
    private float businessImpactFactor;
}
