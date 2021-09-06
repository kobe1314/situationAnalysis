package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/9/6 上午10:53
 * @version: v1.0
 */
@Data
public class ServerResourceResp {
    private List<String> name;
    private List<Float> value;
}
