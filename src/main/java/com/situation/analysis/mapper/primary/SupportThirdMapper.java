package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.*;
import com.situation.analysis.entity.secondary.ThirdResultEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    Entity4Record getHolographic(String code);

    IndicatorEntity4ObjectC1 getIndicatorRecord4ObjectC1(String code);

    IndicatorEntity4ObjectC2 getIndicatorRecord4ObjectC2(String code);

    Entity4Record getObject(@Param("code") String code, @Param("object_name") String object_name);

    Entity4Record getBusinessRecord(@Param("code") String code, @Param("business_name") String business_name);

    List<HolographicRecordEntity> selectHealthByCode(List<ThirdResultEntity>  list);


    IndicatorEntity4ObjectD1 getServerResource(String code);
    
    IndicatorEntity4ObjectC3 getImageQualityData(String code);


}
