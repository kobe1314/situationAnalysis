package com.situation.analysis.handler;

import com.situation.analysis.annotation.HandlerType;
import com.situation.analysis.event.Event202;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: handlerA
 * @author: Kobe
 * @date: 2021/3/23 下午9:46
 * @version: v1.0
 */
@Slf4j
@HandlerType(202)
@Component
public class Handler202 extends AbstractHandler{

    @Resource
    ApplicationContext applicationContext;

    @Override
    public void handle(int taskNo) {
        log.info("test handler A");
        applicationContext.publishEvent(new Event202(this,taskNo));
    }
}
