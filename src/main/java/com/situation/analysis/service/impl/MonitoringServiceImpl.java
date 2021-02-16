package com.situation.analysis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situation.analysis.bean.PageRequest;
import com.situation.analysis.bean.PageResult;
import com.situation.analysis.entity.MonitoringLevel;
import com.situation.analysis.mapper.MonitoringLevelMapper;
import com.situation.analysis.service.MonitoringService;
import com.situation.analysis.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * @return List<MonitoringLevel>
     */
    @Override
    public List<MonitoringLevel> getAllMonitoringLevels() {
        return monitoringLevelMapper.selectAllMonitoringLevels();
    }

    /**
     * @param pageRequest
     * @return List<MonitoringLevel>
     */
    @Override
    public PageResult<MonitoringLevel> getMonitoringLevelsByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    private PageInfo<MonitoringLevel> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<MonitoringLevel> list = monitoringLevelMapper.selectMonitoringLevelsByPage();
        return new PageInfo<MonitoringLevel>(list);
    }
}
