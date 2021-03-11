package com.situation.analysis.mapper;

import com.situation.analysis.entity.MonitoringObjectEntity;

/**
 * @description: Monitoring object
 * @author: Kobe
 * @date: 2021/3/9 下午9:03
 * @version: v1.0
 */
public interface MonitoringObjectMapper {

    int addMonitoringObject(MonitoringObjectEntity objectEntity);
    
    void deleteMonitoringObject(int id);
}
