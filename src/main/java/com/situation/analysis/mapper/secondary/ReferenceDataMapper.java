package com.situation.analysis.mapper.secondary;

import com.situation.analysis.entity.secondary.ResultEntity;
import com.situation.analysis.entity.secondary.VideoResultEntity;

import java.util.List;

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

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4A21();

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4A22();

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4A23();


    /**
     * @param taskType
     * @return
     */
    List<Object> getTaskIds(int taskType);

    /**
     * this is for C11 and C21
     * @param taskIds
     * @return
     */
    ResultEntity checkTaskResultRecord4C(List<Object> taskIds);

    /**
     * @param taskIds
     * @return
     */
    ResultEntity checkTaskResultRecord4C12(List<Object> taskIds);


    /**
     * @param taskIds
     * @return
     */
    ResultEntity checkTaskResultRecord4C22(List<Object> taskIds);

    /**
     * @param taskIds
     * @return
     */
    ResultEntity checkTaskResultRecord4C23(List<Object> taskIds);

    /**
     * @param taskIds
     * @return
     */
    List<String> getVqdresList(List<Object> taskIds);



}
