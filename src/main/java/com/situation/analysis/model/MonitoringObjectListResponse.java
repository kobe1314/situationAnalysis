package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description: Gain all of monitoring recordings
 * @author: Kobe
 * @date: 2021/3/11 下午5:54
 * @version: v1.0
 */
@Data
public class MonitoringObjectListResponse {
    private List<LevelInfo> objectList;
}
