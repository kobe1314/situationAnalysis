package com.situation.analysis.model;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/9/6 下午2:35
 * @version: v1.0
 */
@Data
@Builder
public class RadarInfo {
    private String name;
    private Integer max;
}
