package com.situation.analysis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 层次记录实体
 * @author: Kobe
 * @date: 2021/2/15 下午4:44
 * @version: v1.0
 */
@Data
public class LevelRecordEntity extends BasedEntity4Record implements Serializable {
    private int lId;
    private float healthRating;
}
