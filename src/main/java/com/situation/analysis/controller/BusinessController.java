package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.*;
import com.situation.analysis.entity.MonitoringLevelEntity;
import com.situation.analysis.service.BusinessService;
import com.situation.analysis.service.MonitoringService;
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
@ResponseResult
public class BusinessController {
    @Resource
    private BusinessService businessService;

    @PostMapping("business")
    public void addBusiness(@RequestBody BusinessRequest request) {
        log.debug("start add business");
        businessService.addNewBusiness(request);
    }

    @DeleteMapping("business")
    public void deleteBusiness(@RequestParam int id) {
        log.debug("start delete business");
        businessService.deleteBusiness(id);
    }

    @PutMapping("business")
    public void updateBusiness(@RequestBody BusinessRequest request) {
        log.debug("start update business");
        businessService.updateBusiness(request);
    }
    @GetMapping("businesses")
    public BusinessResponse getBusinessResponse(@RequestParam(required = false) String keyWord) {
        log.debug("start get business list");
        return businessService.getBusinessInfoList(keyWord);
    }

}
