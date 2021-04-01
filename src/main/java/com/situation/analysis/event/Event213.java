package com.situation.analysis.event;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 202
 * @author: Kobe
 * @date: 2021/3/24 下午8:24
 * @version: v1.0
 */
@Slf4j
public class Event213 extends BasedEvent {
    public Event213(Object source, int taskNum) {
        super(source, taskNum);
    }
}
