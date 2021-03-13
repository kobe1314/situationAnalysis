package com.situation.analysis.controller;

import com.github.pagehelper.util.StringUtil;
import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.AddMonitoringObjectRequest;
import com.situation.analysis.model.MonitoringObjectListResponse;
import com.situation.analysis.model.Option;
import com.situation.analysis.service.ObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("objects")
    public MonitoringObjectListResponse selectObjectList(@RequestParam(required = false) String keyWord) {
        return objectService.getMonitoringObjectList(keyWord);
    }

    @PutMapping("object")
    public void updateObject(@RequestBody AddMonitoringObjectRequest request) {
        log.debug("start update object");
        objectService.updateObject(request);
    }

    @GetMapping("objectOptions")
    public List<Option> getObjectOptionList() {
        return objectService.getObjectOptionList();
    }
}
