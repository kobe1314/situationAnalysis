package com.situation.analysis.service.impl;

import com.situation.analysis.constants.CommonConstant;
import com.situation.analysis.event.BasedEvent;
import com.situation.analysis.handler.AbstractHandler;
import com.situation.analysis.model.NoticeRequest;
import com.situation.analysis.process.HandlerContext;
import com.situation.analysis.service.RecordService;
import com.situation.analysis.service.NoticeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/24 上午9:03
 * @version: v1.0
 */
@Data
@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {


    private final static Map<String, Integer[]> RELATION_MAP;

    static {
        RELATION_MAP = new HashMap();
        RELATION_MAP.put("视频流采集设备A1", CommonConstant.SUPPORT_EVENT_ARRAY_A1);
        RELATION_MAP.put("图像数据采集设备A2", CommonConstant.SUPPORT_EVENT_ARRAY_A2);
        RELATION_MAP.put("实时视频流质量C1", CommonConstant.SUPPORT_EVENT_ARRAY_C1);
        RELATION_MAP.put("历史视频质量C2", CommonConstant.SUPPORT_EVENT_ARRAY_C2);
        RELATION_MAP.put("图像数据质量C3", CommonConstant.SUPPORT_EVENT_ARRAY_C3);
    }

    @Resource
    HandlerContext context;
    
    @Resource
    RecordService recordService;

    @Resource
    ApplicationContext applicationContext;

    @Override
    public void updateInformation(NoticeRequest request) {
        int tasktype = request.getTasktype();
        int cityCode = request.getCityCode();
        applicationContext.publishEvent(new BasedEvent(this, request.getTaskno(),tasktype,cityCode));

        List<String> objectNames = getObjectNameList(tasktype);
        recordService.updatedLevelRecord(objectNames,cityCode);

        log.debug("finish notice updated!");
    }

    private List<String> getObjectNameList(int tasktype) {
        List<String> objects = new ArrayList();
        RELATION_MAP.forEach((key,value) -> {
            if(Arrays.asList(value).contains(tasktype))  {
                objects.add(key);
            }
        });
        return objects;
    }
}
