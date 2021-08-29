package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.KernelDataResponse;
import com.situation.analysis.service.SupportThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/holographic/selectListByGroup")
    public List<KernelDataResponse> selectListByGroup (@RequestParam String code){
        log.debug("start selectListByGroup, code is {}",code);
        return supportThirdService.selectListByGroup(code);
    }

    @GetMapping("/holographic/getKernelData")
    public List<KernelDataResponse> getKernelData(@RequestParam String code){
        log.debug("start getKernelData, code is {}",code);
        return supportThirdService.getKernelData(code);
    }

    @GetMapping("/holographic/networkSharePlatform")
    public List<KernelDataResponse> getNetworkSharePlatform(@RequestParam String code){
        log.debug("start getNetworkSharePlatform, code is {}",code);
        return supportThirdService.getNetworkSharePlatform(code);
    }
}
