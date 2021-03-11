package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.AddIndicatorRequest;
import com.situation.analysis.model.IndicatorResponse;
import com.situation.analysis.service.IndicatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: indicator controller
 * @author: Kobe
 * @date: 2021/3/11 下午11:09
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
public class IndicatorController {

    @Resource
    private IndicatorService indicatorService;

    @GetMapping("indicators")
    public List<IndicatorResponse> getIndicatorList(@RequestParam(required = false) String key) {
        log.debug("start indicator list");
        return indicatorService.getIndicatorList(key);
    }

    @PostMapping("indicator")
    public void addIndicator(@RequestBody AddIndicatorRequest request) {
        log.debug("start add indicator");
        indicatorService.addIndicator(request);
        log.info("finish add indicator");
    }

    @DeleteMapping("indicator")
    public void deleteIndicator(@RequestParam int id) {
        log.debug("start delete indicator");
        indicatorService.deleteIndicator(id);
    }
}
