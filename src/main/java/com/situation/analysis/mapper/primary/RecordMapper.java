package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.IndicatorEntity4ObjectA;
import com.situation.analysis.entity.IndicatorEntity4ObjectC1;
import com.situation.analysis.entity.ObjectEntity4Record;

/**
 * @description: IndicatorRecordMapper
 * @author: Kobe
 * @date: 2021/3/24 下午8:53
 * @version: v1.0
 */
public interface RecordMapper {

    /**
     * @param objectA
     */
    void addIndicatorRecord4ObjectA(IndicatorEntity4ObjectA objectA);

    /**
     * @param objectEntity4Record
     */
    void addRecord4ObjectA(ObjectEntity4Record objectEntity4Record);

    /**
     * @param objectC1 
     */
    void addIndicatorRecord4ObjectC1(IndicatorEntity4ObjectC1 objectC1);

    /**
     * @param objectEntity4Record
     */
    void addRecord4ObjectC1(ObjectEntity4Record objectEntity4Record);

}
