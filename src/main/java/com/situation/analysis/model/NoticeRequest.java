package com.situation.analysis.model;

import lombok.Data;

/**
 * @description: notice request
 * @author: Kobe
 * @date: 2021/3/23 下午9:06
 * @version: v1.0
 */
@Data
public class NoticeRequest {
    private int taskno;
    private int tasktype;
    private int cityCode;
}
