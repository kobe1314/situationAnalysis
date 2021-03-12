package com.situation.analysis.service;

import com.situation.analysis.model.AddMonitoringObjectRequest;
import com.situation.analysis.model.MonitoringObjectListResponse;

/**
 * @description: object service
 * @author: Kobe
 * @date: 2021/3/11 下午11:11
 * @version: v1.0
 */
public interface ObjectService {

    /**
     * add object
     *
     * @param request
     */
    void addObject(AddMonitoringObjectRequest request);

    /**
     * @param id
     */
    void deleteObject(int id);

    /**
     * @return
     */
    MonitoringObjectListResponse getMonitoringObjectList(String keyWord);
}
