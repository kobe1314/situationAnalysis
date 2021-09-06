package com.situation.analysis.service.impl;

import com.situation.analysis.entity.*;
import com.situation.analysis.entity.secondary.ThirdResultEntity;
import com.situation.analysis.mapper.primary.SupportThirdMapper;
import com.situation.analysis.mapper.secondary.ReferenceDataMapper;
import com.situation.analysis.model.ApplicationResponse;
import com.situation.analysis.model.AreaResponse;
import com.situation.analysis.model.KernelDataResponse;
import com.situation.analysis.model.ServerResourceResp;
import com.situation.analysis.service.SupportThirdService;
import com.situation.analysis.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private ReferenceDataMapper referenceDataMapper;

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
    public List<KernelDataResponse> getAnalysisSystemData(String code) {
        log.info("start getAnalysisSystemData code: {}", code);
        List<KernelDataResponse> list = new ArrayList<>();
        Entity4Record a1 = supportThirdMapper.getObject(code, "图像数据采集设备A2");
        if (null != a1) {
            list.add(KernelDataResponse.builder().name("图像数据采集设备").threshold(a1.getHealthRating()).build());
        }
        Entity4Record c1 = supportThirdMapper.getObject(code, "图像数据质量C3");
        if (null != c1) {
            list.add(KernelDataResponse.builder().name("图像数据质量").threshold(c1.getHealthRating()).build());
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
        if (null != a1) {
            list.add(KernelDataResponse.builder().name("视频流采集设备").threshold(a1.getHealthRating()).build());
        }
        Entity4Record c1 = supportThirdMapper.getObject(code, "实时视频流质量C1");
        if (null != c1) {
            list.add(KernelDataResponse.builder().name("实时视频流质量").threshold(c1.getHealthRating()).build());
        }
        Entity4Record c2 = supportThirdMapper.getObject(code, "历史视频质量C2");
        if (null != c2) {
            list.add(KernelDataResponse.builder().name("历史视频质量").threshold(c2.getHealthRating()).build());
        }
        Entity4Record d1 = supportThirdMapper.getObject(code, "服务D1");
        if (null != d1) {
            list.add(KernelDataResponse.builder().name("联网/共享服务").threshold(d1.getHealthRating()).build());
        }
        return list;
    }

    @Override
    public List<KernelDataResponse> selectHealthByCode(String code) {

        List<ThirdResultEntity> childrenCode = referenceDataMapper.getChildrenCode(code);
        log.info("childrenCode length: {}", childrenCode.size());
        List<HolographicRecordEntity> entities = supportThirdMapper.selectHealthByCode(childrenCode);

        if (null == entities) {
            return null;
        }

        entities.forEach(entity -> {
            childrenCode.forEach(node -> {
                if (node.getAreaId().equals(entity.getCode())) {
                    entity.setName(node.getAreaName());
                }
            });
        });
        return entities.stream().map(entity -> KernelDataResponse.builder().name(entity.getName()).threshold(entity.getHealthRating()).build()).collect(Collectors.toList());
    }

    @Override
    public AreaResponse selectCodeByName(String name) {
        log.info("start selectCodeByName name: {}", name);
        String code = referenceDataMapper.getCode(name);
        return AreaResponse.builder().code(code).name(name).build();
    }

    @Override
    public ServerResourceResp getServerResource(String code) {
        log.info("start getServerResource code: {}", code);
        ServerResourceResp resp = new ServerResourceResp();
        List<String> name = Arrays.asList("服务连通率", "服务完整率", "服务使用率", "服务延指标");
        IndicatorEntity4ObjectD1 serverResource = supportThirdMapper.getServerResource(code);
        List<Float> value = Arrays.asList(Util.convertFloat(serverResource.getServiceConnectedRatingD11()),
                Util.convertFloat(serverResource.getServiceCompletedRatingD12()),
                Util.convertFloat(serverResource.getServiceUsingRatingD13()),
                Util.convertFloat(serverResource.getServiceDelayRatingD14()));
        resp.setName(name);
        resp.setValue(value);
        return resp;
    }

    @Override
    public List<ApplicationResponse> getImageQualityData(String code) {

        List<ApplicationResponse> list = new ArrayList<>();
        IndicatorEntity4ObjectC3 data = supportThirdMapper.getImageQualityData(code);
        if (null != data) {
            list.add(ApplicationResponse.builder().name("图像完好率").value(Util.convertFloat(data.getImageCompletedRatingC31())).build());
            list.add(ApplicationResponse.builder().name("图像数据一致率").value(Util.convertFloat(data.getImageAlignRatingC32())).build());
            list.add(ApplicationResponse.builder().name("结构化数据稳定性行").value(Util.convertFloat(data.getStableRatingC33())).build());
            list.add(ApplicationResponse.builder().name("结构化数据规范").value(Util.convertFloat(data.getStandardRatingC34())).build());
        }
        return list;
    }
}
