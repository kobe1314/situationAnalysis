package com.situation.analysis.entity.secondary;

import lombok.Data;

import java.util.List;

/**
 * @description: video
 * @author: Kobe
 * @date: 2021/3/31 下午2:35
 * @version: v1.0
 */
@Data
public class VideoResultEntity {
    private List<String> vqdresList;
    private String code;
}
