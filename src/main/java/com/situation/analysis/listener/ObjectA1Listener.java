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

        if (!Util.includeSpecifyTaskType(CommonConstant.SUPPORT_EVENT_ARRAY_A1, event202.getTaskType())) {
            return;
        }

        int taskNum = event202.getTaskNum();
        //A11,A12,A13,A14
        ResultEntity result4A11 = referenceDataMapper.checkTaskResultRecord4A11();
        ResultEntity taskResult4A12 = referenceDataMapper.checkTaskResultRecord4A12(taskNum);
        ResultEntity taskResult4A13 = referenceDataMapper.checkTaskResultRecord4A13(taskNum);
        ResultEntity result4A14 = referenceDataMapper.checkTaskResultRecord4A14();
        log.info("添加所有区域A1对象的指标");
        calculateIndicatorObject(null,result4A11,taskResult4A12,taskResult4A13,result4A14);

        List<ResultEntity> result4A11List = referenceDataMapper.checkTaskResultRecord4A11ByGroup();
        List<ResultEntity> taskResult4A12List = referenceDataMapper.checkTaskResultRecord4A12ByGroup(taskNum);
        List<ResultEntity> taskResult4A13List = referenceDataMapper.checkTaskResultRecord4A13ByGroup(taskNum);
        List<ResultEntity> result4A14List = referenceDataMapper.checkTaskResultRecord4A14ByGroup();

        result4A11List.stream().forEach(entity -> {
            Integer code = entity.getCivilcode();
            log.info("对象A1添加区域：{}的指标",code);
            ResultEntity taskResult4A12l = Util.getResultEntity(taskResult4A12List,code);
            ResultEntity taskResult4A13l = Util.getResultEntity(taskResult4A13List,code);
            ResultEntity taskResult4A14l = Util.getResultEntity(result4A14List,code);
            calculateIndicatorObject(code,entity,taskResult4A12l,taskResult4A13l,taskResult4A14l);
        });

        log.debug("add new record for object A of indicators");

    }

    private void calculateIndicatorObject(Integer code, ResultEntity result4A11, ResultEntity taskResult4A12, ResultEntity taskResult4A13, ResultEntity result4A14) {
        float onlineRating = 1 - Util.calculateRating(result4A11.getOfflineDuration(), 24 * 60 * result4A11.getTotalRecords());
        float connectedRating = Util.calculateRating(taskResult4A12.getSuccessRecords(), taskResult4A12.getTotalRecords());
        float reachedRating = 1 - Util.calculateRating(taskResult4A13.getFailRecords(), taskResult4A12.getTotalRecords());
        float exceptionRating = 1 - Util.calculateRating(result4A14.getFailRecords(), result4A14.getTotalRecords());
        IndicatorEntity4ObjectA objectA = createIndicatorEntity4ObjectA(onlineRating, connectedRating, reachedRating, exceptionRating, code);
        recordMapper.addIndicatorRecord4ObjectA(objectA);
        updateRecordObject(code,onlineRating, connectedRating, reachedRating, exceptionRating);
    }

    private void updateRecordObject(Integer code, float onlineRating, float connectedRating, float reachedRating, float exceptionRating) {
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
    }

    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos, float onlineRating, float connectedRating, float reachedRating, float exceptionRating) {
        float onlineRatingResult = Util.getImpactedFactor(indicatorInfos, "在线率A11") * onlineRating;
        float connectedRatingResult = Util.getImpactedFactor(indicatorInfos, "连通率A12") * connectedRating;
        float reachedRatingResult = Util.getImpactedFactor(indicatorInfos, "时延超标率A13") * reachedRating;
        float exceptionRatingResult = Util.getImpactedFactor(indicatorInfos, "使用异常A14") * exceptionRating;
        float finalResult = onlineRatingResult + connectedRatingResult + reachedRatingResult + exceptionRatingResult;
        return finalResult;
    }

    private IndicatorEntity4ObjectA createIndicatorEntity4ObjectA(float onlineRating, float connectedRating, float reachedRating, float exceptionRating, Integer code) {
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
