package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.PageRequest;
import com.situation.analysis.model.PageResult;
import com.situation.analysis.entity.MonitoringLevel;
import com.situation.analysis.service.MonitoringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: business
 * @author: Kobe
 * @date: 2021/2/15 下午4:51
 * @version: v1.0
 */
@Slf4j
@RestController
public class BusinessController {
    @Resource
    private MonitoringService monitoringService;

    @ResponseResult
    @RequestMapping("monitoringLevel")
    public List<MonitoringLevel> getAllMonitoringLevels() {
        log.debug("start monitoring level controller");
        return monitoringService.getAllMonitoringLevels();
    }

    @PostMapping("monitoringLevel")
    public PageResult<MonitoringLevel> getMonitoringLevelsByPage(@RequestBody PageRequest pageRequest) {
        log.debug("pageNumber:{},pageSize:{}", pageRequest.getPageNum(), pageRequest.getPageSize());
        return monitoringService.getMonitoringLevelsByPage(pageRequest);
    }
}
