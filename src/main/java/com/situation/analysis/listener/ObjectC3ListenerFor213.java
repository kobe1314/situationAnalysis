package com.situation.analysis.listener;

import com.situation.analysis.entity.IndicatorEntity4ObjectC3;
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
import java.util.Optional;

/**
 * @description: listener
 * @author: Kobe
 * @date: 2021/3/24 下午8:33
 * @version: v1.0
 */
@Slf4j
@Component
public class ObjectC3ListenerFor213 implements ApplicationListener<BasedEvent> {

    private static final Integer[] SUPPORT_EVENT_ARRAYS = new Integer[]{213, 215, 216};

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
    public void onApplicationEvent(BasedEvent basedEvent) {
        log.debug("C21 listener task num: {}", basedEvent.getTaskNum());

        if(!Util.includeSpecifyTaskType(SUPPORT_EVENT_ARRAYS,basedEvent.getTaskType())) {
            return;
        }

        //C31
        List<Object> taskIds215 = referenceDataMapper.getTaskIds(215);
        ResultEntity result4C31 = referenceDataMapper.checkTaskResultRecord4C(taskIds215);
        List<String> vList = referenceDataMapper.getVqdresList4C3(taskIds215);
        int successRecords = Util.calculateQualified(vList);
        float c31Rating = Util.calculateRating(successRecords, result4C31.getTotalRecords());

        //C32
        List<Object> taskIds213 = referenceDataMapper.getTaskIds(213);
        ResultEntity result4C32 = referenceDataMapper.checkTaskResultRecord4C32Or34(taskIds213);
        float c32Rating = Util.calculateRating(result4C32.getSuccessRecords(), result4C32.getTotalRecords());

        //C33
        ResultEntity result4C33 = Optional.ofNullable(referenceDataMapper.checkTaskResultRecord4C33()).orElse(new ResultEntity());
        float c33Rating = Util.calculateRating(result4C33.getSuccessRecords(), result4C33.getTotalRecords());

        //C34
        List<Object> taskIds217 = referenceDataMapper.getTaskIds(217);
        ResultEntity result4C34 = referenceDataMapper.checkTaskResultRecord4C32Or34(taskIds217);
        float c34Rating = Util.calculateRating(result4C34.getSuccessRecords(), result4C34.getTotalRecords());

        IndicatorEntity4ObjectC3 indicators = createIndicatorEntity4Object(c31Rating, c32Rating, c33Rating, c34Rating);
        recordMapper.addIndicatorRecord4ObjectC3(indicators);

        Integer oId = monitoringObjectMapper.getObjectId("图像数据质量C3");
        List<IndicatorInfo> indicatorInfos = indicatorMapper.getIndicatorBindObject(oId);
        if (ObjectUtils.isEmpty(indicatorInfos)) {
            throw new BizException(1000, "图像数据质量C3未发现绑定的指标");
        }

        float healthRating = calculateHealthRating(indicatorInfos, c31Rating, c32Rating, c33Rating, c34Rating);
        ObjectEntity4Record record = Util.createObjectEntity4Record(healthRating);
        recordMapper.addRecord4ObjectC3(record);

        log.debug("add new record for object C3 of indicators");
    }

    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos, float c31Rating, float c32Rating, float c33Rating, float c34Rating) {
        float c31RatingResult = Util.getImpactedFactor(indicatorInfos, "录像完好率C21") * c31Rating;
        float c32RatingResult = Util.getImpactedFactor(indicatorInfos, "录像完整率C22") * c32Rating;
        float c33RatingResult = Util.getImpactedFactor(indicatorInfos, "标注完好率C23") * c33Rating;
        float c34RatingResult = Util.getImpactedFactor(indicatorInfos, "标注完好率C23") * c34Rating;
        float finalResult = c31RatingResult + c32RatingResult + c34RatingResult + c34RatingResult;
        return finalResult;
    }

    private IndicatorEntity4ObjectC3 createIndicatorEntity4Object(float c31Rating, float c32Rating, float c33Rating, float c34Rating) {
        IndicatorEntity4ObjectC3 c3 = new IndicatorEntity4ObjectC3();
        c3.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        c3.setImageCompletedRatingC31(c31Rating);
        c3.setImageAlignRatingC32(c32Rating);
        c3.setStableRatingC33(c33Rating);
        c3.setStandardRatingC34(c34Rating);
        return c3;
    }
}


//C1 ----》 C11
//c2 ----> C21