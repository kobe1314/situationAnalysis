package com.situation.analysis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situation.analysis.entity.IndicatorEntity;
import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.mapper.IndicatorMapper;
import com.situation.analysis.mapper.MonitoringLevelMapper;
import com.situation.analysis.mapper.MonitoringObjectMapper;
import com.situation.analysis.model.*;
import com.situation.analysis.service.MonitoringService;
import com.situation.analysis.util.JwtUtil;
import com.situation.analysis.util.PageUtil;
import com.situation.analysis.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Monitoring service implement
 * @author: Kobe
 * @date: 2021/2/16 上午9:30
 * @version: v1.0
 */
@Slf4j
@Service
public class MonitoringServiceImpl implements MonitoringService {

    @Resource
    private MonitoringLevelMapper monitoringLevelMapper;

    @Resource
    private IndicatorMapper indicatorMapper;
    @Resource
    private MonitoringObjectMapper monitoringObjectMapper;

    /**
     * @return List<MonitoringLevel>
     */
    @Override
    public List<MonitoringLevelResponse> getAllMonitoringLevels() {
        List<MonitoringLevelEntity> list = monitoringLevelMapper.selectAllMonitoringLevels();
        BeanCopier copier = BeanCopier.create(MonitoringLevelEntity.class, MonitoringLevelResponse.class, false);
        return list.stream().map(monitoringLevelEntity -> {
            MonitoringLevelResponse monitoringLevel = new MonitoringLevelResponse();
            copier.copy(monitoringLevelEntity, monitoringLevel, null);
            return monitoringLevel;
        }).collect(Collectors.toList());
    }

    /**
     * @param pageRequest
     * @return List<MonitoringLevel>
     */
    @Override
    public PageResult<MonitoringLevelEntity> getMonitoringLevelsByPage(PageRequest pageRequest) {
        return PageUtil.getPageResult(getPageInfo(pageRequest));
    }

    @Override
    public List<IndicatorResponse> getIndicatorList() {
        List<IndicatorEntity> list = indicatorMapper.getIndicatorList();
        BeanCopier copier = BeanCopier.create(IndicatorEntity.class, IndicatorResponse.class, false);
        return list.stream().map(indicatorEntity -> {
            IndicatorResponse indicator = new IndicatorResponse();
            copier.copy(indicatorEntity, indicator, null);
            return indicator;
        }).collect(Collectors.toList());
    }

    /**
     * add object
     *
     * @param request
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void addObject(AddMonitoringObjectRequest request) {

        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = "";
        if(!StringUtils.isEmpty(token)) {
            username = JwtUtil.getUsernameFromToken(token);
        }
        MonitoringObjectEntity objectEntity = new MonitoringObjectEntity();
        objectEntity.setName(request.getObjectName());
        objectEntity.setRunThreshold(request.getRunThreshold());
        objectEntity.setLevelId(request.getLevelId());
        objectEntity.setCreatedBy(username);
        objectEntity.setCreatedTime(new Date().toLocaleString());

        int insertId = monitoringObjectMapper.addMonitoringObject(objectEntity);
        log.info("adding object id is {}", insertId);

        List<IndicatorInformation> iList = request.getIndicatorInformationList();
        iList.stream().forEach(indicator -> {
            indicator.setObjectId(insertId);
        });
        indicatorMapper.batchUpdateIndicator(iList);
        log.debug("finish add object");
    }

    private PageInfo<MonitoringLevelEntity> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<MonitoringLevelEntity> list = monitoringLevelMapper.selectMonitoringLevelsByPage();
        return new PageInfo<MonitoringLevelEntity>(list);
    }
}
