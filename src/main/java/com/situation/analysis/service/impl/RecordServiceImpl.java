package com.situation.analysis.service.impl;

import com.situation.analysis.entity.*;
import com.situation.analysis.mapper.primary.MonitoringLevelMapper;
import com.situation.analysis.mapper.primary.MonitoringObjectMapper;
import com.situation.analysis.mapper.primary.RecordMapper;
import com.situation.analysis.mapper.secondary.ReferenceDataMapper;
import com.situation.analysis.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/4/4 下午10:03
 * @version: v1.0
 */
@Slf4j
@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    MonitoringObjectMapper monitoringObjectMapper;
    @Resource
    MonitoringLevelMapper monitoringLevelMapper;

    @Resource
    RecordMapper recordMapper;

    @Resource
    private ReferenceDataMapper referenceDataMapper;

    /**
     * @param objectNames
     */
    @Override
    public void updatedLevelRecord(List<String> objectNames,int cityCode) {
        List<Integer> lIds = monitoringObjectMapper.getLevelIds(objectNames);

        lIds.stream().distinct().forEach(lId -> {
            List<MonitoringObjectEntity> list = monitoringObjectMapper.getObjectList(lId,null);
            float healthRating = generatorHealthRating(list);
            log.info("{} 层次的健康度: {}", lId, healthRating);
            LevelRecordEntity lEntity = LevelRecordEntity.builder().lId(lId).healthRating(healthRating).build();
            lEntity.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            lEntity.setCode(cityCode);
            recordMapper.addRecord4Level(lEntity);
        });

        if (!ObjectUtils.isEmpty(lIds)) {
            log.info("更新全息健康度");
            updatedHolographicRecord(cityCode);
        }
    }

    /**
     * @param objectNames
     * @param cityCode
     */
    @Override
    public void updatedBusinessRecord(List<String> objectNames, int cityCode) {
        List<Integer> bIds = monitoringObjectMapper.getBusinessIds(objectNames);

        bIds.stream().distinct().forEach(bId -> {
            List<MonitoringObjectEntity> list = monitoringObjectMapper.getObjectList(null,bId);
            float healthRating = generatorHealthRating(list);

            log.info("{} 业务的健康度: {}", bId,healthRating);

            BusinessRecordEntity bEntity = BusinessRecordEntity.builder().bId(bId).healthRating(healthRating).build();
            bEntity.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            bEntity.setCode(cityCode);
            recordMapper.addRecord4Business(bEntity);
            log.info("添加业务记录结束！");
        });
    }

    private float generatorHealthRating(List<MonitoringObjectEntity> list) {
        float healthRating = (float) list.stream().map(
                entity -> {
                    Entity4Record record = Optional.ofNullable(recordMapper.getObjectValue(entity.getId())).orElse(new Entity4Record());
                    return record.getHealthRating() * entity.getImpactFactor();
                }
        ).mapToDouble(value -> value).sum();
        return healthRating;
    }


    private void updatedHolographicRecord(int cityCode) {
        List<MonitoringLevelEntity> eList = monitoringLevelMapper.selectAllMonitoringLevels();
        float healthRating = (float) eList.stream().map(entity -> {
            Entity4Record record = Optional.ofNullable(recordMapper.getLevelValue(entity.getId())).orElse(new Entity4Record());
            return record.getHealthRating() * entity.getImpactFactor();
        }).mapToDouble(value -> value).sum();
        log.info("更新全息健康度: {}", healthRating);
        HolographicRecordEntity hEntity = HolographicRecordEntity.builder().healthRating(healthRating).build();
        hEntity.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        hEntity.setCode(cityCode);
        hEntity.setName(referenceDataMapper.getAreaName(String.valueOf(cityCode)));
        recordMapper.addRecord4Holographic(hEntity);
    }


}
