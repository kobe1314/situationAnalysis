package com.situation.analysis.service.impl;

import com.situation.analysis.event.Event202;
import com.situation.analysis.handler.AbstractHandler;
import com.situation.analysis.model.NoticeRequest;
import com.situation.analysis.process.HandlerContext;
import com.situation.analysis.service.NoticeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    HandlerContext context;

    @Resource
    ApplicationContext applicationContext;

    @Override
    public void updateInformation(NoticeRequest request) {
        AbstractHandler handler = context.getInstance(request.getTasktype());
        handler.handle(request.getTaskno());

        applicationContext.publishEvent(new Event202(this,request.getTaskno()));

        log.debug("finish notice updated!");
    }
}
