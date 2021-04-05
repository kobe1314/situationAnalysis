package com.situation.analysis.service.impl;

import com.situation.analysis.entity.LevelRecordEntity;
import com.situation.analysis.service.LevelRecordService;
import com.situation.analysis.service.ObjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/4/4 下午10:03
 * @version: v1.0
 */
@Service
public class LevelRecordServiceImpl implements LevelRecordService {

    @Resource
    ObjectService objectService;
    /**
     * @param objectNames
     */
    @Override
    public void updatedLevelRecord(List<String> objectNames) {
        List<Integer> lIds = objectService.getLevelIds(objectNames);
    }
}
