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
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4A11ByGroup();

    /**
     * @param taskNum
     * @return
     */
    ResultEntity checkTaskResultRecord4A12(int taskNum);

    /**
     * @param taskNum
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4A12ByGroup(int taskNum);

    /**
     * @param taskNum
     * @return
     */
    ResultEntity checkTaskResultRecord4A13(int taskNum);

    /**
     * @param taskNum
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4A13ByGroup(int taskNum);

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4A14();

    /**
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4A14ByGroup();

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
     * this is for C11/C21/C31
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


    /**
     * @param taskIds
     * @return
     */
    ResultEntity checkTaskResultRecord4C32Or34(List<Object> taskIds);

    /**
     * @param
     * @return
     */
    ResultEntity checkTaskResultRecord4C33();


    /**
     * @param taskIds
     * @return
     */
    List<String> getVqdresList4C3(List<Object> taskIds);

    /**
     * @return
     */
    ResultEntity checkTaskResultRecord4D();

    /**
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4D11();

    /**
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4D12();


    /**
     * @return
     */
    List<ResultEntity> checkTaskResultRecord4D14();


}
