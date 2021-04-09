package com.situation.analysis.listener;

import com.situation.analysis.constants.CommonConstant;
import com.situation.analysis.entity.IndicatorEntity4ObjectC3;
import com.situation.analysis.entity.IndicatorEntity4ObjectD1;
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
public class ObjectD1Listener implements ApplicationListener<BasedEvent> {

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
        log.debug("D1 listener task num: {}", basedEvent.getTaskNum());

        int code = basedEvent.getCityCode();

        ResultEntity result4D = referenceDataMapper.checkTaskResultRecord4D();
        int totalRecords = result4D.getTotalRecords();

        //D11
        List<ResultEntity> result4D11 = referenceDataMapper.checkTaskResultRecord4D11();
        float singleRating11 = (float) result4D11.stream().map(resultEntity ->
                Util.calculateRating(resultEntity.getSuccessRecords(), resultEntity.getTotalRecords())).mapToDouble(value -> value).sum();
        float d11Rating = calculateRating(singleRating11,totalRecords);

        //D12
        List<ResultEntity> result4D12 = referenceDataMapper.checkTaskResultRecord4D12();
        float singleRating12 = (float) result4D12.stream().map(resultEntity ->
                Util.calculateRating(resultEntity.getFailRecords(), resultEntity.getTotalRecords())).mapToDouble(value -> value).sum();
        float d12Rating = 1 - calculateRating(singleRating12,totalRecords);

        //D13
        float singleRating13 = (float) result4D12.stream().mapToDouble(entity -> entity.getTotalRecords()).sum();
        float d13Rating = calculateRating(singleRating13,totalRecords);

        //D14
        List<ResultEntity> result4D14 = referenceDataMapper.checkTaskResultRecord4D14();
        float singleRating14 = (float) result4D14.stream().map(resultEntity ->
                Util.calculateRating(resultEntity.getFailRecords(), resultEntity.getTotalRecords())).mapToDouble(value -> value).sum();
        float d14Rating = 1 - calculateRating(singleRating14,totalRecords);

        IndicatorEntity4ObjectD1 indicators = createIndicatorEntity4Object(d11Rating, d12Rating, d13Rating, d14Rating, code);
        recordMapper.addIndicatorRecord4ObjectD1(indicators);

        Integer oId = monitoringObjectMapper.getObjectId("服务D1");
        List<IndicatorInfo> indicatorInfos = indicatorMapper.getIndicatorBindObject(oId);
        if (ObjectUtils.isEmpty(indicatorInfos)) {
            throw new BizException(1000, "服务D1未发现绑定的指标");
        }

        float healthRating = calculateHealthRating(indicatorInfos, d11Rating, d12Rating, d13Rating, d14Rating);
        ObjectEntity4Record record = Util.createObjectEntity4Record(healthRating);
        record.setCode(code);
        record.setOId(oId);
        recordMapper.addRecord4Object(record);

        log.debug("add new record for object D1 of indicators");
    }

    private float calculateRating(float successRecords, int totalRecords) {

        if (totalRecords == 0) {
            return 0;
        }
        return (float) successRecords / totalRecords;
    }
    private float calculateHealthRating(List<IndicatorInfo> indicatorInfos, float d11Rating, float d12Rating, float d13Rating, float d14Rating) {
        float d11RatingResult = Util.getImpactedFactor(indicatorInfos, "服务连通率D11") * d11Rating;
        float d12RatingResult = Util.getImpactedFactor(indicatorInfos, "服务完好率D12") * d12Rating;
        float d13RatingResult = Util.getImpactedFactor(indicatorInfos, "服务使用率D13") * d13Rating;
        float d14RatingResult = Util.getImpactedFactor(indicatorInfos, "服务时延指标D14") * d14Rating;
        float finalResult = d11RatingResult + d12RatingResult + d13RatingResult + d14RatingResult;
        return finalResult;
    }

    private IndicatorEntity4ObjectD1 createIndicatorEntity4Object(float d11Rating, float d12Rating, float d13Rating, float d14Rating, int code) {
        IndicatorEntity4ObjectD1 d1 = IndicatorEntity4ObjectD1.builder()
                .serviceConnectedRatingD11(d11Rating)
                .serviceCompletedRatingD12(d12Rating)
                .serviceUsingRatingD13(d13Rating)
                .serviceDelayRatingD14(d14Rating).build();
        d1.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        d1.setCode(code);
        return d1;
    }
}


//C1 ----》 C11
//c2 ----> C21