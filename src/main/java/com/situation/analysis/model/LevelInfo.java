package com.situation.analysis.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: level info
 * @author: Kobe
 * @date: 2021/3/11 下午5:56
 * @version: v1.0
 */
@Data
public class LevelInfo {
    private int id;
    private String name;
    private BigDecimal impactFactor;
    private int runThreshold;
    private List<ObjectInfo> objectList;
}

