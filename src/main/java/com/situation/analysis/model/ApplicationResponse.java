package com.situation.analysis.model;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/9/6 上午10:10
 * @version: v1.0
 */
@Data
@Builder
public class ApplicationResponse {
    private String name;
    private float value;
}
