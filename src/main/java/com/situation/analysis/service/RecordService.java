package com.situation.analysis.service;

import com.situation.analysis.entity.LevelRecordEntity;

import java.util.List;

/**
 * @description: level record service
 * @author: Kobe
 * @date: 2021/4/4 下午9:56
 * @version: v1.0
 */
public interface RecordService {

    /**
     * @param objectNames
     */
    void updatedLevelRecord(List<String> objectNames, int cityCode);


    /**
     * @param objectNames
     * @param cityCode
     */
    void updatedBusinessRecord(List<String> objectNames,int cityCode);
}
