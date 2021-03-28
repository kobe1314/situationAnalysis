package com.situation.analysis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: option
 * @author: Kobe
 * @date: 2021/3/13 上午11:34
 * @version: v1.0
 */
@Data
public class Option implements Serializable {
    private int id;
    private String name;
}
