package com.situation.analysis.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @description: 202
 * @author: Kobe
 * @date: 2021/3/24 下午8:24
 * @version: v1.0
 */
@Slf4j
public class BasedEvent extends ApplicationEvent {

    private int taskNum;

    public BasedEvent(Object source, int taskNum) {
        super(source);
        this.taskNum = taskNum;
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }
}
