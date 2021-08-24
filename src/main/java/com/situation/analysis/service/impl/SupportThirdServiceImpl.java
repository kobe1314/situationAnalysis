package com.situation.analysis.service.impl;

import com.situation.analysis.entity.HolographicRecordEntity;
import com.situation.analysis.mapper.primary.SupportThirdMapper;
import com.situation.analysis.service.SupportThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: third service
 * @author: Kobe
 * @date: 2021/8/24 下午6:39
 * @version: v1.0
 */
@Slf4j
@Service
public class SupportThirdServiceImpl implements SupportThirdService {

    @Resource
    private SupportThirdMapper supportThirdMapper;

    @Override
    public String getHolographic(String code) {
        log.info("start holographic code: {}",code);
        HolographicRecordEntity holographic = supportThirdMapper.getHolographic(code);
        return Float.toString(holographic.getHealthRating());
    }
}
