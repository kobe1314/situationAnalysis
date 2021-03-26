package com.situation.analysis.mapper.secondary;

import com.situation.analysis.entity.secondary.ResultEntity;

/**
 * @description: Reference data
 * @author: Kobe
 * @date: 2021/3/26 上午10:14
 * @version: v1.0
 */
public interface ReferenceDataMapper {

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4A11();

    /**
     * @param taskNum
     * @return
     */
    ResultEntity checkTaskResultRecord4A12(int taskNum);

    /**
     * @param taskNum
     * @return
     */
    ResultEntity checkTaskResultRecord4A13(int taskNum);

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4A14();

}
