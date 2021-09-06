package com.situation.analysis.service;

import com.situation.analysis.model.*;

import java.util.List;

/**
 * @description: third interface
 * @author: Kobe
 * @date: 2021/8/24 下午6:35
 * @version: v1.0
 */
public interface SupportThirdService {

    String getHolographic(String code);

    List<KernelDataResponse> selectListByGroup(String code);

    List<KernelDataResponse> getAnalysisSystemData(String code);

    List<KernelDataResponse> getKernelData(String code);

    List<KernelDataResponse> getNetworkSharePlatform(String code);

    List<KernelDataResponse> selectHealthByCode(String code);




    AreaResponse selectCodeByName(String name);

    RadarResp getRadarMapData(String code);

    ServerResourceResp getServerResource(String code);

    List<ApplicationResponse> getImageQualityData(String code);

}
