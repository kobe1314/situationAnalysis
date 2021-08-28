package com.situation.analysis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: response
 * @author: Kobe
 * @date: 2021/8/28 下午12:00
 * @version: v1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KernelDataResponse {
    private String name;
    private float threshold;
}
