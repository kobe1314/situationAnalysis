package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description: monitoring
 * @author: Kobe
 * @date: 2021/3/12 上午9:05
 * @version: v1.0
 */
@Data
public class MonitoringObjectInfo {
    private int id;
    private int levelId;
    private String levelName;
    private String objectName;
    private String indicatorName;
    private int runThreshold;
    private float impactFactor;
    private String isOriginalValue;
    private List<IndicatorInfo> indicatorInfoList;
}
