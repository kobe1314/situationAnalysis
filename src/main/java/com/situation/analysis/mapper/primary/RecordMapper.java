package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.*;

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
    void addRecord4Object(ObjectEntity4Record objectEntity4Record);

    /**
     * @param objectC1 
     */
    void addIndicatorRecord4ObjectC1(IndicatorEntity4ObjectC1 objectC1);

    /**
     * @param objectEntity4Record
     */
    void addRecord4ObjectC1(ObjectEntity4Record objectEntity4Record);

    /**
     * @param objectC2
     */
    void addIndicatorRecord4ObjectC2(IndicatorEntity4ObjectC2 objectC2);

    /**
     * @param objectEntity4Record
     */
    void addRecord4ObjectC2(ObjectEntity4Record objectEntity4Record);

    /**
     * @param objectEntity4Record
     */
    void addRecord4ObjectC3(ObjectEntity4Record objectEntity4Record);

    /**
     * @param objectC3
     */
    void addIndicatorRecord4ObjectC3(IndicatorEntity4ObjectC3 objectC3);

    /**
     * @param objectA2
     */
    void addIndicatorRecord4ObjectA2(IndicatorEntity4ObjectA2 objectA2);

    /**
     * @param objectEntity4Record
     */
    void addRecord4ObjectA2(ObjectEntity4Record objectEntity4Record);

    /**
     * @param oId
     * @return
     */
    Entity4Record getObjectValue(int oId);

    /**
     * @param levelRecordEntity
     */
    void addRecord4Level(LevelRecordEntity levelRecordEntity);

    /**
     * @param holographicRecordEntity
     */
    void addRecord4Holographic(HolographicRecordEntity holographicRecordEntity);

    /**
     * @param lId
     * @return
     */
    Entity4Record getLevelValue(int lId);

    /**
     * @param businessRecordEntity
     */
    void addRecord4Business(BusinessRecordEntity businessRecordEntity);

    /**
     * @param objectD1
     */
    void addIndicatorRecord4ObjectD1(IndicatorEntity4ObjectD1 objectD1);

}


