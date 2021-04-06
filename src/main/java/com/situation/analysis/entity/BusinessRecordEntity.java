package com.situation.analysis.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 业务记录实体
 * @author: Kobe
 * @date: 2021/2/15 下午4:44
 * @version: v1.0
 */
@Data
@Builder
public class BusinessRecordEntity extends BasedEntity4Record implements Serializable {
    private int bId;
    private float healthRating;
}
