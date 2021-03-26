package com.situation.analysis.mapper.secondary;

import com.situation.analysis.entity.secondary.TaskResultEntity;

/**
 * @description: Reference data
 * @author: Kobe
 * @date: 2021/3/26 上午10:14
 * @version: v1.0
 */
public interface ReferenceDataMapper {

    TaskResultEntity checkTaskResultRecord4A12(int taskNum);
}
