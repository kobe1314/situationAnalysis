package com.situation.analysis.listener;

import com.situation.analysis.constants.CommonConstant;
import com.situation.analysis.entity.IndicatorEntity4ObjectA;
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
import java.util.Date;
import java.util.List;

/**
 * @description: listener
 * @author: Kobe
 * @date: 2021/3/24 下午8:33
 * @version: v1.0
 */
@Slf4j
@Component
public class ObjectA1Listener implements ApplicationListener<BasedEvent> {

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
    public void onApplicationEvent(BasedEvent event202) {
        log.debug("start ObjectAListenerFor202 listener");

        if(!Util.includeSpecifyTaskType(CommonConstant.SUPPORT_EVENT_ARRAY_A1,event202.getTaskType())) {
            return;
        }

        int taskNum = event202.getTaskNum();
        int code = event202.getCityCode();
        //A11
        ResultEntity result4A11 = referenceDataMapper.checkTaskResultRecord4A11();
        float onlineRating = 1 - Util.calculateRating(result4A11.getOfflineDuration(), 24 * 60 * result4A11.getTotalRecords());

        //A12
        ResultEntity taskResult4A12 = referenceDataMapper.checkTaskResultRecord4A12(taskNum);
        float connectedRating = Util.calculateRating(taskResult4A12.getSuccessRecords(), taskResult4A12.getTotalRecords());

        //A13
        ResultEntity taskResult4A13 = referenceDataMapper.checkTaskResultRecord4A13(taskNum);
        float reachedRating = 1 - Util.calculateRating(taskResult4A13.getFailRecords(), taskResult4A12.getTotalRecords());

        //A14
        ResultEntity result4A14 = referenceDataMapper.checkTaskResultRecord4A14();
        float exceptionRating = 1 - Util.calculateRating(result4A14.getFailRecords(), result4A14.getTotalRecords());

        IndicatorEntity4ObjectA objectA = createIndicatorEntity4ObjectA(onlineRating, connectedRating, reachedRating, exceptionRating,code);

        recordMapper.addIndicatorRecord4ObjectA(objectA);

        int oId = monitoringObjectMapper.getObjectId("视频流采集设备A1");
        List<IndicatorInfo> indicatorInfos = indicatorMapper.getIndicatorBindObject(oId);
        if (ObjectUtils.isEmpty(indicatorInfos)) {
            throw new BizException(1000, "视频流采集设备A1未发现绑定的指标");
        }

        float healthRating = calculateHealthRating(indicatorInfos, onlineRating, connectedRating, reachedRating, exceptionRating);
        ObjectEntity4Record record = Util.createObjectEntity4Record(healthRating);
        record.setCode(code);
        record.setOId(oId);
        recordMapper.addRecord4Object(record);
        log.debug("add new record for object A of indicators");

    }

    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos, float onlineRating, float connectedRating, float reachedRating, float exceptionRating) {
        float onlineRatingResult = Util.getImpactedFactor(indicatorInfos, "在线率 A11") * onlineRating;
        float connectedRatingResult = Util.getImpactedFactor(indicatorInfos, "连通率 A12") * connectedRating;
        float reachedRatingResult = Util.getImpactedFactor(indicatorInfos, "时延超标率 A13") * reachedRating;
        float exceptionRatingResult = Util.getImpactedFactor(indicatorInfos, "使用异常 A14") * exceptionRating;
        float finalResult = onlineRatingResult + connectedRatingResult + reachedRatingResult + exceptionRatingResult;
        return finalResult;
    }

    //private float getImpactedFactor(List<IndicatorInfo> indicatorInfos, String name) {
    //    log.debug("indicator name: {}", name);
    //    IndicatorInfo indicator = indicatorInfos.stream().filter(indicatorInfo -> indicatorInfo.getName().equals(name)).findFirst().get();
    //    return Optional.of(indicator.getImpactFactor()).orElse((float) 0);
    //}

    //private ObjectEntity4Record createObjectEntity4Record(float healthRating) {
    //    ObjectEntity4Record objectEntity4Record = new ObjectEntity4Record();
    //    objectEntity4Record.setDiagTime(new Date().toLocaleString());
    //    objectEntity4Record.setHealthRating(healthRating);
    //    return objectEntity4Record;
    //}

    private IndicatorEntity4ObjectA createIndicatorEntity4ObjectA(float onlineRating, float connectedRating, float reachedRating, float exceptionRating,int code) {
        IndicatorEntity4ObjectA objectA = new IndicatorEntity4ObjectA();
        objectA.setCode(code);
        objectA.setOnlineRatingA11(onlineRating);
        objectA.setConnectRatingA12(connectedRating);
        objectA.setDelayRatingA13(reachedRating);
        objectA.setExceptionRatingA14(exceptionRating);
        objectA.setDiagTime(new Date().toLocaleString());
        return objectA;
    }
}
