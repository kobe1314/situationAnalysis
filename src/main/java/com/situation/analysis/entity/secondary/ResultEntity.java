package com.situation.analysis.entity.secondary;

import lombok.Data;

/**
 * @description: taskResult
 * @author: Kobe
 * @date: 2021/3/26 上午10:32
 * @version: v1.0
 */
@Data
public class ResultEntity {
    private int offlineDuration;
    private int totalRecords;
    private int failRecords;
    private int successRecords;
    private String code;
}
