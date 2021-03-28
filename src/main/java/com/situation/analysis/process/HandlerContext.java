package com.situation.analysis.process;

import com.situation.analysis.handler.AbstractHandler;

import java.util.Map;

/**
 * @description: HandlerContext
 * @author: Kobe
 * @date: 2021/3/24 上午8:56
 * @version: v1.0
 */

public class HandlerContext {
    private Map<Integer,Class> handlerMap;

    public HandlerContext(Map<Integer, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    /**
     * 获取对应任务类型的处理类
     * @param type
     * @return
     */
    public AbstractHandler getInstance(Integer type) {
        Class clazz = handlerMap.get(type);

        if (clazz == null) {
            throw new IllegalArgumentException("未找到任务类型【" + type + "】的处理类");
        }

        return (AbstractHandler) SpringContextUtil.getBean(clazz);
    }

}

