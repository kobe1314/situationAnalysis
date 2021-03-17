package com.situation.analysis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situation.analysis.entity.IndicatorEntity;
import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.mapper.IndicatorMapper;
import com.situation.analysis.model.*;
import com.situation.analysis.service.IndicatorService;
import com.situation.analysis.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/11 下午11:13
 * @version: v1.0
 */
@Slf4j
@Service
public class IndicatorServiceImpl implements IndicatorService {

    @Resource
    private IndicatorMapper indicatorMapper;

    /**
     * @param keyWord
     * @return
     */
    @Override
    public PageResult<IndicatorResponse> getIndicatorList(String keyWord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<IndicatorResponse> list = indicatorMapper.selectIndicatorList(keyWord);
        return PageUtil.getPageResult(new PageInfo<IndicatorResponse>(list));
    }

    /**
     * @param request
     */
    @Override
    public void addIndicator(AddIndicatorRequest request) {
        IndicatorEntity entity = new IndicatorEntity();
        entity.setName(request.getName());
        entity.setInstruction(request.getInstruction());
        entity.setObjectId(request.getOId());
        entity.setIsOriginalValue("N");
        int id = indicatorMapper.addIndicator(entity);
        log.info("add indicator successfully");
    }

    /**
     * @param id
     */
    @Override
    public void deleteIndicator(int id) {
        log.info("delete indicator id is : {}", id);
        indicatorMapper.deleteIndicator(id);
    }

    /**
     * @return
     */
    @Override
    public List<Option> getIndicatorOptionList() {
        log.info("start indicator option list");
        return indicatorMapper.getIndicatorOptionList();
    }
}
