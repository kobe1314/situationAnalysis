package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.exception.BizException;
import com.situation.analysis.model.PageRequest;
import com.situation.analysis.model.PageResult;
import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.service.MonitoringService;
import com.situation.analysis.vo.Indicator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("monitoringLevel")
    public List<MonitoringLevelEntity> getAllMonitoringLevels() {
        log.debug("start monitoring level controller");
        throw new BizException(400,"this is testing");
        //return monitoringService.getAllMonitoringLevels();
    }
    @ResponseResult
    @PostMapping("monitoringLevel")
    public PageResult<MonitoringLevelEntity> getMonitoringLevelsByPage(@RequestBody PageRequest pageRequest) {
        log.debug("pageNumber:{},pageSize:{}", pageRequest.getPageNum(), pageRequest.getPageSize());
        return monitoringService.getMonitoringLevelsByPage(pageRequest);
    }
    

    @GetMapping("indicators")
    public List<Indicator> getIndicatorList() {
        log.debug("start indicator list");
        return monitoringService.getIndicatorList();
    }
}
