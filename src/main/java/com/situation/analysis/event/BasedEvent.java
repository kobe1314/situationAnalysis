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

    private int taskType;

    private int cityCode;

    public BasedEvent(Object source, int taskNum, int taskType) {
        super(source);
        this.taskNum = taskNum;
        this.taskType = taskType;
    }

    public BasedEvent(Object source, int taskNum, int taskType, int cityCode) {
        super(source);
        this.taskNum = taskNum;
        this.taskType = taskType;
        this.cityCode = cityCode;
    }

    public int getTaskNum() {
        return taskNum;
    }

    public int getTaskType() {
        return taskType;
    }

    public int getCityCode() {
        return cityCode;
    }
}
