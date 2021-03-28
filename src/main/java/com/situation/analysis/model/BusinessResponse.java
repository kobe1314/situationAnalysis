package com.situation.analysis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: BusinessResponse
 * @author: Kobe
 * @date: 2021/3/13 上午11:33
 * @version: v1.0
 */
@Data
public class BusinessResponse implements Serializable {
    private List<BusinessInfo> businessInfoList;
}
