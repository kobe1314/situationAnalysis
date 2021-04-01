package com.situation.analysis.handler;

import com.situation.analysis.annotation.HandlerType;
import com.situation.analysis.event.BasedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/3/23 下午9:48
 * @version: v1.0
 */
@Slf4j
@HandlerType(210)
@Component
public class Handler210 extends AbstractHandler {

    @Resource
    ApplicationContext applicationContext;

    @Override
    public void handle(int taskNo) {

        log.info("start handler 210");
        applicationContext.publishEvent(new BasedEvent(this, taskNo,210));
    }
}
