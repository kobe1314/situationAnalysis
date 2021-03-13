package com.situation.analysis.controller;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.model.LevelInfo;
import com.situation.analysis.service.LevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: level
 * @author: Kobe
 * @date: 2021/3/12 上午8:31
 * @version: v1.0
 */
@Slf4j
@RestController
@ResponseResult
public class LevelController {

    @Resource
    private LevelService levelService;
    
    @GetMapping("levels")
    public List<LevelInfo> getLevelInfoList() {
        log.debug("start level info  list");
        return levelService.getLevelInfoList();
    }
    
    @PutMapping("level")
    public void updateLevelInfo(@RequestBody LevelInfo levelInfo) {
        log.debug("start level info ");
        levelService.updateLevelInfo(levelInfo);
    }
}
