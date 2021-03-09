package com.situation.analysis.model;

import java.util.List;

/**
 * @description: 添加监测对象
 * @author: Kobe
 * @date: 2021/3/9 下午10:17
 * @version: v1.0
 */
public class AddMonitoringObjectRequest {
    private String objectName;
    private int runThreshold;
    private int levelId;
    private List<IndicatorInformation> indicatorInformationList;
}
