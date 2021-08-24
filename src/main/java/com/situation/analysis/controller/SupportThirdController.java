package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.service.SupportThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: support third api
 * @author: Kobe
 * @date: 2021/8/24 上午11:59
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
public class SupportThirdController {

    @Resource
    private SupportThirdService supportThirdService;

    @GetMapping("/holographic/selectListRealTime")
    public Map<String,String> getHolographic(@RequestParam String code){
        log.debug("start get holographic, code is {}",code);
        Map<String,String> map = new HashMap<>();
        map.put("healthScore",supportThirdService.getHolographic(code));
        return map;
    }
}
