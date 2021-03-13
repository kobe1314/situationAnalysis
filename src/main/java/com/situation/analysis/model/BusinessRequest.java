package com.situation.analysis.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: request
 * @author: Kobe
 * @date: 2021/3/13 上午11:34
 * @version: v1.0
 */
@Data
public class BusinessRequest {
    /**
     *  pass id in update request
     */
    private int id;
    private String name;
    private String platform;
    private int runThreshold;
    private List<ObjectInfo> objectList;
}
