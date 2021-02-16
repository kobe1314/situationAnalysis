package com.situation.analysis.model;

import lombok.Data;

import java.util.List;

/**
 * @description: PageReuslt
 * @author: Kobe
 * @date: 2021/2/16 上午10:26
 * @version: v1.0
 */
@Data
public class PageResult<T> {
    private int pageNum;
    private int pageSize;
    private int totalSize;
    private int totalPage;
    private List<T> contents;
}
