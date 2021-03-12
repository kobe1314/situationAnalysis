package com.situation.analysis.service.impl;

import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.mapper.IndicatorMapper;
import com.situation.analysis.mapper.MonitoringObjectMapper;
import com.situation.analysis.model.AddMonitoringObjectRequest;
import com.situation.analysis.model.IndicatorInformation;
import com.situation.analysis.model.LevelInfo;
import com.situation.analysis.model.MonitoringObjectListResponse;
import com.situation.analysis.service.ObjectService;
import com.situation.analysis.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/12 上午8:27
 * @version: v1.0
 */
@Slf4j
@Service
public class ObjectServiceImpl implements ObjectService {

    @Resource
    private MonitoringObjectMapper monitoringObjectMapper;

    @Resource
    private IndicatorMapper indicatorMapper;

    /**
     * add object
     *
     * @param request
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addObject(AddMonitoringObjectRequest request) {

        //String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = "";
        //if (!StringUtils.isEmpty(token)) {
        //    username = JwtUtil.getUsernameFromToken(token);
        //}
        MonitoringObjectEntity objectEntity = new MonitoringObjectEntity();
        objectEntity.setName(request.getObjectName());
        objectEntity.setRunThreshold(request.getRunThreshold());
        objectEntity.setLevelId(request.getLevelId());
        objectEntity.setCreatedBy(username);
        objectEntity.setCreatedTime(new Date().toLocaleString());

        monitoringObjectMapper.addMonitoringObject(objectEntity);
        int insertId = objectEntity.getId();
        log.info("adding object id is {}", insertId);

        List<IndicatorInformation> iList = request.getIndicatorInformationList();
        iList.stream().forEach(indicator -> {
            indicator.setObjectId(insertId);
        });
        indicatorMapper.batchUpdateIndicator(iList);
        log.debug("finish add object");
    }

    /**
     * @param id
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteObject(int id) {
        log.info("delete object id: {}", id);
        monitoringObjectMapper.deleteMonitoringObject(id);
        indicatorMapper.updateIndicate(id);
        log.info("finished delete object ");

    }

    /**
     * @return
     */
    @Override
    public MonitoringObjectListResponse getMonitoringObjectList() {
        MonitoringObjectListResponse response = new MonitoringObjectListResponse();

        List<LevelInfo> objectList = new ArrayList<>();
        //List<MonitoringLevelEntity> list = monitoringLevelMapper.selectAllMonitoringLevels();
        //list.stream().map(levelEntity -> {
        //    int lId = levelEntity.getId();
        //})
        //private String levelName;
        //private List<ObjectInfo> objectList;
        return null;
    }
}
