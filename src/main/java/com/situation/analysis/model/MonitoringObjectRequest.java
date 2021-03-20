package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description: 添加监测对象
 * @author: Kobe
 * @date: 2021/3/9 下午10:17
 * @version: v1.0
 */
@Data
public class MonitoringObjectRequest {
    /**
     *  pass id in update request
     */
    private int id;
    private String objectName;
    private int runThreshold;
    private int levelId;
    private List<IndicatorInfo> indicatorInfoList;
}
