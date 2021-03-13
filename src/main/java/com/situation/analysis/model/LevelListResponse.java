package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description: level
 * @author: Kobe
 * @date: 2021/3/12 下午12:11
 * @version: v1.0
 */
@Data
public class LevelListResponse {
    private List<LevelInfo> levelInfoList;
}
