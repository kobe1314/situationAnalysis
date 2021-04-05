package com.situation.analysis.service.impl;

import com.situation.analysis.entity.*;
import com.situation.analysis.mapper.primary.MonitoringLevelMapper;
import com.situation.analysis.mapper.primary.MonitoringObjectMapper;
import com.situation.analysis.mapper.primary.RecordMapper;
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

    /**
     * @param objectNames
     */
    @Override
    public void updatedLevelRecord(List<String> objectNames,int cityCode) {
        List<Integer> lIds = monitoringObjectMapper.getLevelIds(objectNames);

        lIds.stream().forEach(lId -> {
            List<MonitoringObjectEntity> list = monitoringObjectMapper.getObjectList(lId);
            float healthRating = (float) list.stream().map(
                    entity -> {
                        Entity4Record record = Optional.ofNullable(recordMapper.getObjectValue(entity.getId())).orElse(new Entity4Record());
                        return record.getHealthRating() * entity.getImpactFactor();
                    }
            ).mapToDouble(value -> value).sum();
            log.info("层次的健康度: {}", healthRating);
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
        recordMapper.addRecord4Holographic(hEntity);
    }


}
