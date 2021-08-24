package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.HolographicRecordEntity;
import com.situation.analysis.entity.UserEntity;

/**
 * @description: user mapper
 * @author: Kobe
 * @date: 2021/2/28 下午2:55
 * @version: v1.0
 */
public interface SupportThirdMapper {
    /**
     * @param code
     */
    HolographicRecordEntity getHolographic(String code);

}
