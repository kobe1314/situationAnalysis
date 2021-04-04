package com.situation.analysis.listener;

import com.situation.analysis.constants.CommonConstant;
import com.situation.analysis.entity.IndicatorEntity4ObjectC2;
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
public class ObjectC2Listener implements ApplicationListener<BasedEvent> {

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
        log.debug("C21 listener task num: {}", event202.getTaskNum());

        if(!Util.includeSpecifyTaskType(CommonConstant.SUPPORT_EVENT_ARRAY_C2,event202.getTaskType())) {
            return;
        }

        //C21
        List<Object> taskIds210 = referenceDataMapper.getTaskIds(210);
        ResultEntity result4C21 = referenceDataMapper.checkTaskResultRecord4C(taskIds210);
        List<String> vList = referenceDataMapper.getVqdresList(taskIds210);
        int successRecords = Util.calculateQualified(vList);
        float c21Rating = Util.calculateRating(successRecords, result4C21.getTotalRecords());

        //C22
        List<Object> taskIds211 = referenceDataMapper.getTaskIds(211);
        ResultEntity result4C22 = referenceDataMapper.checkTaskResultRecord4C22(taskIds211);
        float c22Rating = Util.calculateRating(result4C22.getSuccessRecords(), result4C22.getTotalRecords());

        //C23
        List<Object> taskIds212 = referenceDataMapper.getTaskIds(212);
        ResultEntity result4C23 = referenceDataMapper.checkTaskResultRecord4C23(taskIds212);
        float c23Rating = Util.calculateRating(result4C23.getSuccessRecords(), result4C23.getTotalRecords());

        IndicatorEntity4ObjectC2 indicators = createIndicatorEntity4Object(c21Rating, c22Rating, c23Rating);
        recordMapper.addIndicatorRecord4ObjectC2(indicators);

        int oId = monitoringObjectMapper.getObjectId("历史视频质量C2");
        List<IndicatorInfo> indicatorInfos = indicatorMapper.getIndicatorBindObject(oId);
        if (ObjectUtils.isEmpty(indicatorInfos)) {
            throw new BizException(1000, "历史视频质量C2未发现绑定的指标");
        }

        float healthRating = calculateHealthRating(indicatorInfos, c21Rating, c22Rating, c23Rating);
        ObjectEntity4Record record = Util.createObjectEntity4Record(healthRating);
        recordMapper.addRecord4ObjectC2(record);

        log.debug("add new record for object C of indicators");
    }

    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos, float c21Rating, float c22Rating, float c23Rating) {
        float c21RatingResult = Util.getImpactedFactor(indicatorInfos, "录像完好率C21") * c21Rating;
        float c22RatingResult = Util.getImpactedFactor(indicatorInfos, "录像完整率C22") * c22Rating;
        float c23RatingResult = Util.getImpactedFactor(indicatorInfos, "标注完好率C23") * c23Rating;
        float finalResult = c21RatingResult + c22RatingResult + c23RatingResult;
        return finalResult;
    }

    private IndicatorEntity4ObjectC2 createIndicatorEntity4Object(float c21Rating, float c22Rating, float c23Rating) {
        IndicatorEntity4ObjectC2 c2 = new IndicatorEntity4ObjectC2();
        c2.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        c2.setVideoRatingC21(c21Rating);
        c2.setCompleteRatingC22(c22Rating);
        c2.setAnnotationRatingC23(c23Rating);
        return c2;
    }
}


//C1 ----》 C11
//c2 ----> C21