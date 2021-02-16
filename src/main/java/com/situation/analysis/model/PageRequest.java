package com.situation.analysis.model;

import lombok.Data;

/**
 * @description: Page Request
 * @author: Kobe
 * @date: 2021/2/16 上午10:24
 * @version: v1.0
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
}
