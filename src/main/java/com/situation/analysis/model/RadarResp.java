package com.situation.analysis.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/9/6 上午10:23
 * @version: v1.0
 */
@Data
@Builder
public class RadarResp {
    private List<RadarInfo> name;
    private List<Float> value;
}
