package com.situation.analysis.service.impl;

import com.situation.analysis.mapper.MonitoringLevelMapper;
import com.situation.analysis.model.LevelInfoResponse;
import com.situation.analysis.service.LevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/12 下午4:22
 * @version: v1.0
 */
@Slf4j
@Service
public class LevelServiceImpl implements LevelService {

    @Resource
    private MonitoringLevelMapper monitoringLevelMapper;


    /**
     * @return List<LevelInfoResponse>
     */
    @Override
    public List<LevelInfoResponse> getLevelInfoList() {
        return monitoringLevelMapper.getLevelInfoList();
    }
}
