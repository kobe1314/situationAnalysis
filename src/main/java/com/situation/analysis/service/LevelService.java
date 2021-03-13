package com.situation.analysis.service;

import com.situation.analysis.model.LevelInfo;

import java.util.List;

/**
 * @description: level service
 * @author: Kobe
 * @date: 2021/3/11 下午11:11
 * @version: v1.0
 */
public interface LevelService {

    /**
     * @return List<LevelInfoResponse>
     */
    List<LevelInfo> getLevelInfoList();

    /**
     * @param levelInfo
     */
    void updateLevelInfo(LevelInfo levelInfo);
}
