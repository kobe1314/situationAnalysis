package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.IndicatorEntity4ObjectA;

/**
 * @description: IndicatorRecordMapper
 * @author: Kobe
 * @date: 2021/3/24 下午8:53
 * @version: v1.0
 */
public interface IndicatorRecordMapper {

    /**
     * @param objectA
     */
    void addIndicatorRecord4ObjectA(IndicatorEntity4ObjectA objectA);
}
