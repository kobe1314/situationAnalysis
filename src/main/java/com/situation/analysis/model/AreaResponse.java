package com.situation.analysis.model;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/9/6 上午9:25
 * @version: v1.0
 */
@Data
@Builder
public class AreaResponse {
    private String name;
    private String code;
}
