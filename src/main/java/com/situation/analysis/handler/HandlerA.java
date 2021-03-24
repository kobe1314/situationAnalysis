package com.situation.analysis.handler;

import com.situation.analysis.annotation.HandlerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: handlerA
 * @author: Kobe
 * @date: 2021/3/23 下午9:46
 * @version: v1.0
 */
@Slf4j
@HandlerType(11)
@Component
public class HandlerA extends AbstractHandler{
    @Override
    public void handle(int taskNo) {
        log.info("test handler A");
    }
}
