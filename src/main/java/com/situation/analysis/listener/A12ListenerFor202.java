package com.situation.analysis.listener;

import com.situation.analysis.entity.IndicatorEntity4ObjectA;
import com.situation.analysis.entity.secondary.ResultEntity;
import com.situation.analysis.event.Event202;
import com.situation.analysis.mapper.primary.IndicatorRecordMapper;
import com.situation.analysis.mapper.secondary.ReferenceDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: listener
 * @author: Kobe
 * @date: 2021/3/24 下午8:33
 * @version: v1.0
 */
@Slf4j
@Component
 public class A12ListenerFor202 implements ApplicationListener<Event202> {

    @Resource
    ReferenceDataMapper referenceDataMapper;

    @Resource
    IndicatorRecordMapper indicatorRecordMapper;

    @Override
    public void onApplicationEvent(Event202 event202) {

        int taskNum = event202.getTaskNum();
        //A11
        ResultEntity result4A11 = referenceDataMapper.checkTaskResultRecord4A11();
        float onlineRating = 1 - (float)result4A11.getOfflineDuration() / 24 * 60 * result4A11.getTotalRecords();

        //A12
        ResultEntity taskResult4A12 = referenceDataMapper.checkTaskResultRecord4A12(taskNum);
        float connectedRating = (float)taskResult4A12.getSuccessRecords() / taskResult4A12.getTotalRecords();

        //A13
        ResultEntity taskResult4A13 = referenceDataMapper.checkTaskResultRecord4A13(taskNum);
        float reachedRating = 1 - (float)taskResult4A13.getFailRecords() / taskResult4A12.getTotalRecords();

        //A14
        ResultEntity result4A14 = referenceDataMapper.checkTaskResultRecord4A14();
        float exceptionRating = (float)result4A14.getFailRecords() / result4A14.getTotalRecords();

        IndicatorEntity4ObjectA objectA = new IndicatorEntity4ObjectA();
        objectA.setOnlineRatingA11(onlineRating);
        objectA.setConnectRatingA12(connectedRating);
        objectA.setDelayRatingA13(reachedRating);
        objectA.setExceptionRatingA14(exceptionRating);
        objectA.setDiagTime(new Date().toLocaleString());

        indicatorRecordMapper.addIndicatorRecord4ObjectA(objectA);
        log.debug("add new record for object A of indicators");

    }
}
