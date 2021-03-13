package com.situation.analysis.service;

import com.situation.analysis.model.*;
import com.situation.analysis.entity.MonitoringLevelEntity;

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
    //List<MonitoringLevelResponse> getAllMonitoringLevels();


    /**
     * @param pageRequest
     * @return List<MonitoringLevel>
     */
    PageResult<MonitoringLevelEntity> getMonitoringLevelsByPage(PageRequest pageRequest);
    



    
    

}
