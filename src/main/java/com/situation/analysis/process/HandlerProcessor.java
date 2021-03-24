package com.situation.analysis.process;

import com.google.common.collect.Maps;
import com.situation.analysis.annotation.HandlerType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: processor
 * @author: Kobe
 * @date: 2021/3/24 上午8:23
 * @version: v1.0
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {
    private static final String HANDLER_PACKAGE = "com.situation.analysis.handler";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<Integer,Class> handlerMap = Maps.newHashMapWithExpectedSize(20);
        ClassScanner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            //获取注解中的类型值
            HandlerType handlerType = (HandlerType) clazz.getAnnotation(HandlerType.class);
            int type = handlerType.value();
            //将注解中的value作为Key,将其注册到spring容器中
            handlerMap.put(type,clazz);
        });

        HandlerContext context = new HandlerContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(HandlerContext.class.getName(),context);

    }
}
