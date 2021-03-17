package com.situation.analysis.service;

import com.situation.analysis.model.AddIndicatorRequest;
import com.situation.analysis.model.IndicatorResponse;
import com.situation.analysis.model.Option;
import com.situation.analysis.model.PageResult;

import java.util.List;

/**
 * @description: indicator Service
 * @author: Kobe
 * @date: 2021/3/11 下午11:10
 * @version: v1.0
 */
public interface IndicatorService {
    /**
     * @param keyWord
     * @return
     */
    PageResult<IndicatorResponse> getIndicatorList(String keyWord, int pageNum, int pageSize);

    /**
     * @param request
     */
    void addIndicator(AddIndicatorRequest request);

    /**
     * @param id
     */
    void deleteIndicator(int id);

    /**
     * @return
     */
    List<Option> getIndicatorOptionList();
}
