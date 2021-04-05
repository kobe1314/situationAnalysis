package com.situation.analysis.listener;

import com.situation.analysis.constants.CommonConstant;
import com.situation.analysis.entity.IndicatorEntity4ObjectA2;
import com.situation.analysis.entity.ObjectEntity4Record;
import com.situation.analysis.entity.secondary.ResultEntity;
import com.situation.analysis.event.BasedEvent;
import com.situation.analysis.exception.BizException;
import com.situation.analysis.mapper.primary.IndicatorMapper;
import com.situation.analysis.mapper.primary.MonitoringObjectMapper;
import com.situation.analysis.mapper.primary.RecordMapper;
import com.situation.analysis.mapper.secondary.ReferenceDataMapper;
import com.situation.analysis.model.IndicatorInfo;
import com.situation.analysis.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @description: listener
 * @author: Kobe
 * @date: 2021/3/24 下午8:33
 * @version: v1.0
 */
@Slf4j
@Component
public class ObjectA2Listener implements ApplicationListener<BasedEvent> {

    @Resource
    ReferenceDataMapper referenceDataMapper;

    @Resource
    RecordMapper recordMapper;

    @Resource
    MonitoringObjectMapper monitoringObjectMapper;

    @Resource
    IndicatorMapper indicatorMapper;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void onApplicationEvent(BasedEvent event205) {
        log.debug("start ObjectA2ListenerFor205 listener");

        if(!Util.includeSpecifyTaskType(CommonConstant.SUPPORT_EVENT_ARRAY_A2,event205.getTaskType())) {
            return;
        }

        int taskNum = event205.getTaskNum();
        //A21
        ResultEntity result4A21 = referenceDataMapper.checkTaskResultRecord4A21();
        float a21Rating = 1 - Util.calculateRating(result4A21.getOfflineDuration(), 24 * 60 * result4A21.getTotalRecords());

        //A22
        ResultEntity taskResult4A22 = referenceDataMapper.checkTaskResultRecord4A22();
        float a22Rating = Util.calculateRating(taskResult4A22.getSuccessRecords(), taskResult4A22.getTotalRecords());

        //A23
        ResultEntity taskResult4A23 = referenceDataMapper.checkTaskResultRecord4A23();
        float a23Rating = Util.calculateRating(taskResult4A23.getFailRecords(), taskResult4A23.getTotalRecords());

        IndicatorEntity4ObjectA2 objectA2 = createIndicatorEntity4ObjectA2(a21Rating, a22Rating, a23Rating);

        recordMapper.addIndicatorRecord4ObjectA2(objectA2);

        Integer oId = monitoringObjectMapper.getObjectId("图像数据采集设备A2");
        List<IndicatorInfo> indicatorInfos = indicatorMapper.getIndicatorBindObject(oId);
        if (ObjectUtils.isEmpty(indicatorInfos)) {
            throw new BizException(1000, "图像数据采集设备A2未发现绑定的指标");
        }

        float healthRating = calculateHealthRating(indicatorInfos, a21Rating, a22Rating, a23Rating);
        ObjectEntity4Record record = Util.createObjectEntity4Record(healthRating);
        record.setOId(oId);
        recordMapper.addRecord4Object(record);
        log.debug("add new record for object A2 of indicators");

    }

    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos, float a21Rating, float a22Rating, float a23Rating) {
        float a21RatingResult = Util.getImpactedFactor(indicatorInfos, "在线率A21") * a21Rating;
        float a22RatingResult = Util.getImpactedFactor(indicatorInfos, "数据量达标率A22") * a22Rating;
        float a23RatingResult = Util.getImpactedFactor(indicatorInfos, "使用异常A23") * a23Rating;
        float finalResult = a21RatingResult + a22RatingResult + a23RatingResult;
        return finalResult;
    }

    private IndicatorEntity4ObjectA2 createIndicatorEntity4ObjectA2(float a21Rating, float a22Rating, float a23Rating) {
        IndicatorEntity4ObjectA2 objectA2 = new IndicatorEntity4ObjectA2();
        objectA2.setOnlineA21(a21Rating);
        objectA2.setCompletedA22(a22Rating);
        objectA2.setExceptionA23(a23Rating);
        objectA2.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        return objectA2;
    }
}
