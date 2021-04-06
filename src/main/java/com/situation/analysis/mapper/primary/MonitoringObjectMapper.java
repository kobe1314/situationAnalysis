package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.model.MonitoringObjectInfo;
import com.situation.analysis.model.ObjectInfo;
import com.situation.analysis.model.Option;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: Monitoring object
 * @author: Kobe
 * @date: 2021/3/9 下午9:03
 * @version: v1.0
 */
@Mapper
public interface MonitoringObjectMapper {

    /**
     * @param objectEntity
     * @return insertId
     */
    Integer addMonitoringObject(MonitoringObjectEntity objectEntity);

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

    /**
     * @param name
     * @return
     */
    Integer getObjectId(String name);

    /**
     * @param objectNames
     * @return
     */
    List<Integer> getLevelIds(List<String> objectNames);

    /**
     * @param lId
     * @return
     */
    List<MonitoringObjectEntity> getObjectList(@Param("lId") Integer lId, @Param("bId") Integer bId);

    /**
     * @param objectNames
     * @return
     */
    List<Integer> getBusinessIds(List<String> objectNames);
}
