package com.situation.analysis.service;

import com.situation.analysis.model.PageRequest;
import com.situation.analysis.model.PageResult;
import com.situation.analysis.entity.MonitoringLevel;

import java.util.List;

/**
 * @description: MonitoringService
 * @author: Kobe
 * @date: 2021/2/15 下午4:52
 * @version: v1.0
 */
public interface MonitoringService {
    /**
     * @return List<MonitoringLevel>
     */
    List<MonitoringLevel> getAllMonitoringLevels();


    /**
     * @param pageRequest
     * @return List<MonitoringLevel>
     */
    PageResult<MonitoringLevel> getMonitoringLevelsByPage(PageRequest pageRequest);
}
