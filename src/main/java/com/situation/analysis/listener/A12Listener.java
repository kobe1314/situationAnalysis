package com.situation.analysis.listener;

import com.situation.analysis.event.Event202;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: listener
 * @author: Kobe
 * @date: 2021/3/24 下午8:33
 * @version: v1.0
 */
@Slf4j
@Component
public class A12Listener implements ApplicationListener<Event202> {

    @Override
    public void onApplicationEvent(Event202 event202) {

        log.debug("a12 listener task num: {}" ,event202.getTaskNum());
    }
}
