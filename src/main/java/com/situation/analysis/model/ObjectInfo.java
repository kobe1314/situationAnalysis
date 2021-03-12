package com.situation.analysis.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: object info
 * @author: Kobe
 * @date: 2021/3/11 下午5:58
 * @version: v1.0
 */
@Data
public class ObjectInfo {
    private int id;
    private String objectName;
    private BigDecimal impactFactor;
}
