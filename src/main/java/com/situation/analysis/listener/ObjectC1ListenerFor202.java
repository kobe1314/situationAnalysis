package com.situation.analysis.listener;

import com.situation.analysis.entity.IndicatorEntity4ObjectC1;
import com.situation.analysis.entity.ObjectEntity4Record;
import com.situation.analysis.entity.secondary.ResultEntity;
import com.situation.analysis.event.Event202;
import com.situation.analysis.exception.BizException;
import com.situation.analysis.mapper.primary.IndicatorMapper;
import com.situation.analysis.mapper.primary.MonitoringObjectMapper;
import com.situation.analysis.mapper.primary.RecordMapper;
import com.situation.analysis.mapper.secondary.ReferenceDataMapper;
import com.situation.analysis.model.IndicatorInfo;
import com.situation.analysis.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: listener
 * @author: Kobe
 * @date: 2021/3/24 下午8:33
 * @version: v1.0
 */
@Slf4j
@Component
public class ObjectC1ListenerFor202 implements ApplicationListener<Event202> {


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
    public void onApplicationEvent(Event202 event202) {

        log.debug("C11 listener task num: {}", event202.getTaskNum());
        int taskNum = event202.getTaskNum();

        //C11
        List<Object> taskIds208 = referenceDataMapper.getTaskIds(208);
        ResultEntity result4C11 = referenceDataMapper.checkTaskResultRecord4C(taskIds208);
        float c11Rating = Util.calculateRating(result4C11.getSuccessRecords(),result4C11.getTotalRecords());

        //C12
        List<Object> taskIds209 = referenceDataMapper.getTaskIds(209);
        ResultEntity result4C12 = referenceDataMapper.checkTaskResultRecord4C12(taskIds209);
        float c12Rating = Util.calculateRating(result4C12.getSuccessRecords(),result4C12.getTotalRecords());

        IndicatorEntity4ObjectC1 indicators = createIndicatorEntity4ObjectC1(c11Rating, c12Rating);
        recordMapper.addIndicatorRecord4ObjectC1(indicators);

        int oId = monitoringObjectMapper.getObjectId("实时视频流质量C1");
        List<IndicatorInfo> indicatorInfos = indicatorMapper.getIndicatorBindObject(oId);
        if (ObjectUtils.isEmpty(indicatorInfos)) {
            throw new BizException(1000,"实时视频流质量C1未发现绑定的指标");
        }

        float healthRating = calculateHealthRating(indicatorInfos, c11Rating, c12Rating);
        ObjectEntity4Record record = Util.createObjectEntity4Record(healthRating);;
        recordMapper.addRecord4ObjectC1(record);

        log.debug("add new record for object C of indicators");
    }

    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos,float videoRatingC11, float annotationRatingC12 ) {
        float c11RatingResult = Util.getImpactedFactor(indicatorInfos, "视频流完好率C11") * videoRatingC11;
        float c12RatingResult = Util.getImpactedFactor(indicatorInfos, "标注完好率C12") * annotationRatingC12;
        float finalResult = c11RatingResult + c12RatingResult;
        return finalResult;
    }
    
    private IndicatorEntity4ObjectC1 createIndicatorEntity4ObjectC1(float videoRatingC11, float annotationRatingC12) {
        IndicatorEntity4ObjectC1 c1 = new IndicatorEntity4ObjectC1();
        c1.setVideoRatingC11(videoRatingC11);
        c1.setAnnotationRatingC12(annotationRatingC12);
        return c1;
    }
    
}
