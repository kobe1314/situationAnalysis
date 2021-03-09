package com.situation.analysis.mapper;

import com.situation.analysis.entity.IndicatorEntity;

import java.util.List;

/**
 * @description: indicator
 * @author: Kobe
 * @date: 2021/3/9 下午8:16
 * @version: v1.0
 */
public interface IndicatorMapper {

    /**
     * @return List<IndicatorEntity>
     */
    List<IndicatorEntity> getIndicatorList();
}
