package com.situation.analysis.service.impl;

import com.situation.analysis.entity.LevelRecordEntity;
import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.entity.ObjectEntity4Record;
import com.situation.analysis.mapper.primary.MonitoringObjectMapper;
import com.situation.analysis.mapper.primary.RecordMapper;
import com.situation.analysis.service.LevelRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class LevelRecordServiceImpl implements LevelRecordService {

    @Resource
    MonitoringObjectMapper monitoringObjectMapper;
    
    @Resource
    RecordMapper recordMapper;

    /**
     * @param objectNames
     */
    @Override
    public void updatedLevelRecord(List<String> objectNames) {
        List<Integer> lIds = monitoringObjectMapper.getLevelIds(objectNames);

        lIds.stream().forEach(lId -> {
            List<MonitoringObjectEntity> list = monitoringObjectMapper.getObjectList(lId);
            float healthRating = (float) list.stream().map(
                    entity -> {
                        ObjectEntity4Record record = Optional.ofNullable(recordMapper.getObjectValue(entity.getId())).orElse(new ObjectEntity4Record());
                        return record.getHealthRating() * entity.getImpactFactor();
                    }
            ).mapToDouble(value -> value).sum();
            log.info("层次的健康度：{}", healthRating);
            LevelRecordEntity lEntity = LevelRecordEntity.builder().lId(lId).healthRating(healthRating).build();
            lEntity.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            recordMapper.addRecord4Level(lEntity);
        });
    }
    

}
