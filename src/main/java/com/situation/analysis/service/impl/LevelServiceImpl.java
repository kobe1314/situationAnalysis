package com.situation.analysis.service.impl;

import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.mapper.MonitoringLevelMapper;
import com.situation.analysis.mapper.MonitoringObjectMapper;
import com.situation.analysis.model.LevelInfo;
import com.situation.analysis.model.ObjectInfo;
import com.situation.analysis.service.LevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/12 下午4:22
 * @version: v1.0
 */
@Slf4j
@Service
public class LevelServiceImpl implements LevelService {

    @Resource
    private MonitoringLevelMapper monitoringLevelMapper;

    @Resource
    private MonitoringObjectMapper monitoringObjectMapper;


    /**
     * @return List<LevelInfoResponse>
     */
    @Override
    public List<LevelInfo> getLevelInfoList() {
        return monitoringLevelMapper.getLevelInfoList();
    }

    /**
     * @param levelInfo
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateLevelInfo(LevelInfo levelInfo) {
        log.info("update level info");

        monitoringLevelMapper.updateLevelInfo(createEntity(levelInfo));
        monitoringObjectMapper.batchUpdateMonitoringObject(crateEntities(levelInfo));
        log.info("finish update leve info");

    }

    private List<MonitoringObjectEntity> crateEntities(LevelInfo levelInfo) {
        List<ObjectInfo> objectList = levelInfo.getObjectList();

        return objectList.stream().map(objectInfo -> {
            MonitoringObjectEntity entity = new MonitoringObjectEntity();
            entity.setId(objectInfo.getId());
            entity.setLevelId(levelInfo.getId());
            entity.setImpactFactor(objectInfo.getImpactFactor());
            return entity;
        }).collect(Collectors.toList());
    }

    private MonitoringLevelEntity createEntity(LevelInfo levelInfo) {
        MonitoringLevelEntity levelEntity = new MonitoringLevelEntity();
        levelEntity.setId(levelInfo.getId());
        levelEntity.setImpactFactor(levelInfo.getImpactFactor());
        levelEntity.setRunThreshold(levelInfo.getRunThreshold());
        levelEntity.setUpdatedBy("kobe");
        levelEntity.setUpdatedTime(new Date().toLocaleString());
        return levelEntity;
    }
}
