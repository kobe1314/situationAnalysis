package com.situation.analysis.mapper;

import com.situation.analysis.entity.IndicatorEntity;
import com.situation.analysis.model.IndicatorInfo;
import com.situation.analysis.model.IndicatorResponse;
import com.situation.analysis.model.Option;

import java.util.List;

/**
 * @description: indicator
 * @author: Kobe
 * @date: 2021/3/9 下午8:16
 * @version: v1.0
 */
public interface IndicatorMapper {

    /**
     * @return List<Option>
     */
    List<Option> getIndicatorOptionList();

    /**
     * @param list
     */
    void batchUpdateIndicator(List<IndicatorInfo> list);

    /**
     * @param oId
     */
    void unbindObjectWithIndicator(int oId);

    /**
     * @param oId
     * @return
     */
    List<IndicatorInfo> getIndicatorBindObject(Object oId);

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
