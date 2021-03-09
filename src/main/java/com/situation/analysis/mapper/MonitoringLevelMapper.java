package com.situation.analysis.mapper;

import com.situation.analysis.entity.MonitoringLevelEntity;

import java.util.List;

/**
 * @description: Monitoring Service
 * @author: Kobe
 * @date: 2021/2/16 上午10:40
 * @version: v1.0
 */

public interface MonitoringLevelMapper {
    /**
     * @return List<MonitoringLevel>
     */
    List<MonitoringLevelEntity> selectAllMonitoringLevels();

    /**
     * @return List<MonitoringLevel>
     */
    List<MonitoringLevelEntity> selectMonitoringLevelsByPage();
}
