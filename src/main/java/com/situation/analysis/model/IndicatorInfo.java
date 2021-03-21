package com.situation.analysis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/3/9 下午10:21
 * @version: v1.0
 */
@Data
public class IndicatorInfo {
    private int id;
    private String name;
    private BigDecimal impactFactor;
    private int objectId;
    private boolean isChosen;
}
