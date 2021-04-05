package com.situation.analysis.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @description: base record for object
 * @author: Kobe
 * @date: 2021/3/27 上午8:59
 * @version: v1.0
 */
@Data
public class BasedEntity4Record {
    private int id;
    private String diagTime;
    private String code;
    private String name;
}
