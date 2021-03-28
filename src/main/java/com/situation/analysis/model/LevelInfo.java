package com.situation.analysis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: level info
 * @author: Kobe
 * @date: 2021/3/11 下午5:56
 * @version: v1.0
 */
@Data
public class LevelInfo implements Serializable {
    private int id;
    private String name;
    private float impactFactor;
    private int runThreshold;
    private List<ObjectInfo> objectList;
}

