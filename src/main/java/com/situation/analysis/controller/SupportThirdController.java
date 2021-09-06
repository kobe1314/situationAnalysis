package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.ApplicationResponse;
import com.situation.analysis.model.AreaResponse;
import com.situation.analysis.model.KernelDataResponse;
import com.situation.analysis.model.ServerResourceResp;
import com.situation.analysis.service.SupportThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<KernelDataResponse> selectListByGroup(@RequestParam String code){
        log.debug("start selectListByGroup, code is {}",code);
        return supportThirdService.selectListByGroup(code);
    }

    @GetMapping("/holographic/getAnalysisSystemData")
    public List<KernelDataResponse> getAnalysisSystemData(@RequestParam String code){
        log.debug("start selectListByGroup, code is {}",code);
        return supportThirdService.getAnalysisSystemData(code);
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

    @GetMapping("/holographic/selectHealthByCode")
    public List<KernelDataResponse> selectHealthByCode(@RequestParam String code){
        log.debug("start getNetworkSharePlatform, code is {}",code);
        return supportThirdService.selectHealthByCode(code);
    }


    @GetMapping("/civilcode/selectCodeByName")
    public AreaResponse selectCodeByName(@RequestParam String name){
        log.debug("start selectCodeByName, name is {}",name);
        return supportThirdService.selectCodeByName(name);
    }


    //Todo: don't have the corresponding metric
    @GetMapping("/holographic/basicFacilityByName")
    public Map basicFacilityByName(@RequestParam String code){
        log.debug("start basicFacilityByName, code is {}",code);
        HashMap hashMap = new HashMap();
        hashMap.put("cpuStatus",0);
        hashMap.put("memoryBankStatus",0);
        hashMap.put("swapSpaceStatus",0);
        hashMap.put("diskUsability",0);
        hashMap.put("networkUsability",0);
        hashMap.put("packetLossProbability",0);
        hashMap.put("flowStatus",0);
        return hashMap;
    }


    //Todo: don't have the corresponding metric
    @GetMapping("/holographic/synthsizeGradeData")
    public Map synthsizeGradeData(@RequestParam String code){
        log.debug("start synthsizeGradeData, code is {}",code);
        HashMap hashMap = new HashMap();
        hashMap.put("applicationPlatform",0);
        hashMap.put("kernelData",0);
        hashMap.put("collectFacility",0);
        hashMap.put("basicFacility",0);
        hashMap.put("serveResource",0);
        return hashMap;
    }

    //Todo: Don't know how to calculate
    @GetMapping("/holographic/getTendencyData")
    public Map getTendencyData(@RequestParam String code){
        log.debug("start synthsizeGradeData, code is {}",code);
        HashMap hashMap = new HashMap();
        hashMap.put("applicationPlatform",0);
        hashMap.put("kernelData",0);
        hashMap.put("collectFacility",0);
        hashMap.put("basicFacility",0);
        hashMap.put("serveResource",0);
        return hashMap;
    }

    //Todo:because don't caculate the object
    @GetMapping("/holographic/getApplicationPlatformData")
    public List<ApplicationResponse> getApplicationPlatformData(@RequestParam String code){
        log.debug("start getApplicationPlatformData, code is {}",code);
        List<ApplicationResponse> list = new ArrayList<>();
        list.add(ApplicationResponse.builder().name("在线率").value(20).build());
        list.add(ApplicationResponse.builder().name("级联稳定率").value(90).build());
        list.add(ApplicationResponse.builder().name("访问率").value(31).build());
        list.add(ApplicationResponse.builder().name("程序稳定率").value(69).build());
        list.add(ApplicationResponse.builder().name("日志可用性").value(44).build());
        return list;
    }

    @GetMapping("/holographic/getRadarMapData")
    public List<ApplicationResponse> getRadarMapData(@RequestParam String code){
        log.debug("start getRadarMapData, code is {}",code);
        List<ApplicationResponse> list = new ArrayList<>();

        //supportThirdService.getRadarMapData(code);

        return list;
    }


    @GetMapping("/holographic/getServerResource")
    public ServerResourceResp getServerResource(@RequestParam String code){
        log.debug("start getServerResource, code is {}",code);

        return supportThirdService.getServerResource(code);
    }




}
