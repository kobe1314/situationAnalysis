package com.situation.analysis.mapper;

import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.model.MonitoringObjectInfo;
import com.situation.analysis.model.ObjectInfo;
import com.situation.analysis.model.Option;

import java.util.List;

/**
 * @description: Monitoring object
 * @author: Kobe
 * @date: 2021/3/9 下午9:03
 * @version: v1.0
 */
public interface MonitoringObjectMapper {

    /**
     * @param objectEntity
     * @return insertId
     */
    int addMonitoringObject(MonitoringObjectEntity objectEntity);

    /**
     * @param id
     */
    void deleteMonitoringObject(int id);

    /**
     * @param objectEntity
     */
    void updateMonitoringObject(MonitoringObjectEntity objectEntity);

    /**
     * @param keyWord
     * @return
     */
    List<MonitoringObjectInfo> selectObjectList(String keyWord);

    /**
     * @param list
     */
    void batchUpdateMonitoringObject(List<MonitoringObjectEntity> list);

    /**
     * @return List<Option>
     */
    List<Option> getObjectOptionList(Object lId);

    /**
     * @param bId
     */
    void unbindObjectWithBusiness(int bId);

    /**
     * @param lId
     */
    void unbindObjectWithLevel(int lId);
}
