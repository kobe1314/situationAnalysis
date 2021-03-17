package com.situation.analysis.service;

import com.situation.analysis.model.*;

import java.util.List;

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
    void addObject(MonitoringObjectRequest request);

    /**
     * @param id
     */
    void deleteObject(int id);

    /**
     * @param request
     */
    void updateObject(MonitoringObjectRequest request);

    /**
     * @return
     */
    PageResult<MonitoringObjectInfo> getMonitoringObjectList(String keyWord, int pageNum, int pageSize);


    /**
     * @return 
     */
    List<Option> getObjectOptionList();
}
