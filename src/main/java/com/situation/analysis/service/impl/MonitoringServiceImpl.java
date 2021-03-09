package com.situation.analysis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situation.analysis.entity.IndicatorEntity;
import com.situation.analysis.mapper.IndicatorMapper;
import com.situation.analysis.model.PageRequest;
import com.situation.analysis.model.PageResult;
import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.mapper.MonitoringLevelMapper;
import com.situation.analysis.service.MonitoringService;
import com.situation.analysis.util.PageUtil;
import com.situation.analysis.model.IndicatorResponse;
import com.situation.analysis.model.MonitoringLevelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    private PageInfo<MonitoringLevelEntity> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<MonitoringLevelEntity> list = monitoringLevelMapper.selectMonitoringLevelsByPage();
        return new PageInfo<MonitoringLevelEntity>(list);
    }
}
