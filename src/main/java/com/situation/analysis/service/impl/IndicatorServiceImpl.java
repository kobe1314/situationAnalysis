package com.situation.analysis.service.impl;

import com.situation.analysis.entity.IndicatorEntity;
import com.situation.analysis.mapper.IndicatorMapper;
import com.situation.analysis.model.AddIndicatorRequest;
import com.situation.analysis.model.IndicatorResponse;
import com.situation.analysis.service.IndicatorService;
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
     * @param key
     * @return
     */
    @Override
    public List<IndicatorResponse> getIndicatorList(String key) {
        return indicatorMapper.selectIndicatorList(key);
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
        log.info("delete indicator id is : {}",id);
        indicatorMapper.deleteIndicator(id);
    }
}
