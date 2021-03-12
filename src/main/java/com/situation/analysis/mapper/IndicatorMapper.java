package com.situation.analysis.mapper;

import com.situation.analysis.entity.IndicatorEntity;
import com.situation.analysis.model.IndicatorInformation;
import com.situation.analysis.model.IndicatorResponse;
import org.apache.ibatis.annotations.Param;

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

    /**
     * @param indicatorEntity
     */
    void updateIndicator(IndicatorEntity indicatorEntity);

    /**
     * @param list
     */
    void batchUpdateIndicator(List<IndicatorInformation> list);

    /**
     * @param oId
     */
    void updateIndicate(int oId);

    /**
     * @param keyWord
     * @return
     */
    List<IndicatorResponse> selectIndicatorList(String keyWord);

    /**
     * @param indicatorEntity
     */
    int addIndicator(IndicatorEntity indicatorEntity);

    /**
     * @param id
     */
    void deleteIndicator(int id);
}
