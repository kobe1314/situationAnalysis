package com.situation.analysis.utils;

import com.github.pagehelper.PageInfo;
import com.situation.analysis.bean.PageResult;

/**
 * @description: Page utils
 * @author: Kobe
 * @date: 2021/2/16 上午11:00
 * @version: v1.0
 */
public class PageUtils {
    /**
     * @param pageInfo  将分页信息封装到统一的接口
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize((int) pageInfo.getTotal());
        pageResult.setTotalPage(pageInfo.getPages());
        pageResult.setContents(pageInfo.getList());
        return pageResult;
    }
}
