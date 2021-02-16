package com.situation.analysis.mapper;

import com.situation.analysis.entity.MonitoringLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
    List<MonitoringLevel> selectAllMonitoringLevels();

    /**
     * @return List<MonitoringLevel>
     */
    List<MonitoringLevel> selectMonitoringLevelsByPage();
}
