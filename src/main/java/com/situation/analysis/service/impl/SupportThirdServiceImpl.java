package com.situation.analysis.service.impl;

import com.situation.analysis.entity.HolographicRecordEntity;
import com.situation.analysis.entity.IndicatorEntity4ObjectC1;
import com.situation.analysis.entity.IndicatorEntity4ObjectC2;
import com.situation.analysis.mapper.primary.SupportThirdMapper;
import com.situation.analysis.model.KernelDataResponse;
import com.situation.analysis.service.SupportThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        log.info("start getHolographic code: {}", code);
        HolographicRecordEntity holographic = supportThirdMapper.getHolographic(code);
        return Float.toString(holographic.getHealthRating());
    }

    @Override
    public List<KernelDataResponse> getKernelData(String code) {
        log.info("start getKernelData code: {}", code);
        List<KernelDataResponse> list = new ArrayList<>();

        IndicatorEntity4ObjectC1 c1 = supportThirdMapper.getIndicatorRecord4ObjectC1(code);
        if (null != c1) {
            KernelDataResponse videoRatingC11 = new KernelDataResponse();
            videoRatingC11.setName("视频流完好率");
            videoRatingC11.setThreshold(c1.getVideoRatingC11());
            list.add(videoRatingC11);

            KernelDataResponse annotationRatingC12 = new KernelDataResponse();
            annotationRatingC12.setName("标注完好率");
            annotationRatingC12.setThreshold(c1.getAnnotationRatingC12());
            list.add(annotationRatingC12);
        }
        IndicatorEntity4ObjectC2 c2 = supportThirdMapper.getIndicatorRecord4ObjectC2(code);

        if (null != c2) {
            KernelDataResponse videoRatingC21 = new KernelDataResponse();
            videoRatingC21.setName("录像完好率");
            videoRatingC21.setThreshold(c2.getVideoRatingC21());
            list.add(videoRatingC21);

            KernelDataResponse completeRatingC22 = new KernelDataResponse();
            completeRatingC22.setName("录像完整率");
            completeRatingC22.setThreshold(c2.getCompleteRatingC22());
            list.add(completeRatingC22);
        }
        return list;
    }
}
