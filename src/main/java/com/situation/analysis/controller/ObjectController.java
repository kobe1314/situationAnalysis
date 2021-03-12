package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.AddMonitoringObjectRequest;
import com.situation.analysis.service.ObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: object
 * @author: Kobe
 * @date: 2021/3/12 上午8:31
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
public class ObjectController {

    @Resource
    private ObjectService objectService;

    @PostMapping("object")
    public void addObject(@RequestBody AddMonitoringObjectRequest request) {
        log.debug("start add object");
        objectService.addObject(request);
    }

    @DeleteMapping("object")
    public void deleteObject(@RequestParam int id) {
        log.debug("start delete object");
        objectService.deleteObject(id);
    }
}
