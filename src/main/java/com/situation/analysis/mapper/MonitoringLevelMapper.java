package com.situation.analysis.mapper;

import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.model.LevelInfo;
import com.situation.analysis.model.Option;

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


    /**
     * @return List<LevelInfoResponse>
     */
    List<LevelInfo> getLevelInfoList();

    /**
     * @param entity
     */
    void updateLevelInfo(MonitoringLevelEntity entity);


    /**
     * @return List<Option>
     */
    List<Option> getLevelOptionList();
}
