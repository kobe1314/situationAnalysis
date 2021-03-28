package com.situation.analysis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: Indicator
 * @author: Kobe
 * @date: 2021/3/9 下午8:18
 * @version: v1.0
 */
@Data
public class IndicatorResponse implements Serializable {
    private int id;
    private String name;
    private String instruction;
    private String objectName;
    private String isOriginalValue;
}
