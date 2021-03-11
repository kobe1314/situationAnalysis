package com.situation.analysis.model;

import lombok.Data;

/**
 * @description: add indicator
 * @author: Kobe
 * @date: 2021/3/11 下午11:06
 * @version: v1.0
 */
@Data
public class AddIndicatorRequest {
    private String name;
    private int oId;
    private String instruction;
}
