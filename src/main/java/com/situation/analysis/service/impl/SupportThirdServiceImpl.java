package com.situation.analysis.service.impl;

import com.situation.analysis.entity.Entity4Record;
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
import java.util.Arrays;
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
        Entity4Record holographic = supportThirdMapper.getHolographic(code);
        return Float.toString(holographic.getHealthRating());
    }

    @Override
    public List<KernelDataResponse> selectListByGroup(String code) {
        log.info("start selectListByGroup code: {}", code);
        List<KernelDataResponse> list = new ArrayList<>();

        Entity4Record record1 = supportThirdMapper.getBusinessRecord(code, "视频监控联网/共享平台Y1");
        if (null != record1) {
            KernelDataResponse onlineRating = new KernelDataResponse();
            onlineRating.setName("联网平台");
            onlineRating.setThreshold(record1.getHealthRating());
            list.add(onlineRating);
        }

        Entity4Record record = supportThirdMapper.getBusinessRecord(code, "视频图像信息解析系统Y2");
        if (null != record) {
            KernelDataResponse videoRating = new KernelDataResponse();
            videoRating.setName("解析系统");
            videoRating.setThreshold(record.getHealthRating());
            list.add(videoRating);
        }
        return list;
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

    @Override
    public List<KernelDataResponse> getNetworkSharePlatform(String code) {

        List<KernelDataResponse> list = new ArrayList<>();
        Entity4Record a1 = supportThirdMapper.getObject(code, "视频流采集设备A1");
        if(null != a1) {
            list.add(KernelDataResponse.builder().name("视频流采集设备").threshold(a1.getHealthRating()).build());
        }
        Entity4Record c1 = supportThirdMapper.getObject(code, "实时视频流质量C1");
        if(null != a1) {
            list.add(KernelDataResponse.builder().name("实时视频流质量").threshold(c1.getHealthRating()).build());
        }
        Entity4Record c2 = supportThirdMapper.getObject(code, "历史视频质量C2");
        if(null != a1) {
            list.add(KernelDataResponse.builder().name("历史视频质量").threshold(c2.getHealthRating()).build());
        }
        Entity4Record d1 = supportThirdMapper.getObject(code, "服务D1");
        if(null != a1) {
            list.add(KernelDataResponse.builder().name("联网/共享服务").threshold(d1.getHealthRating()).build());
        }
        return list;
    }
}
