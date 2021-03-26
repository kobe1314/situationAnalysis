package com.situation.analysis.mapper.primary;

import com.situation.analysis.entity.BusinessEntity;
import com.situation.analysis.model.BusinessInfo;

import java.util.List;

/**
 * @description: BusinessMapper
 * @author: Kobe
 * @date: 2021/3/13 下午3:09
 * @version: v1.0
 */
public interface BusinessMapper {
    /**
     * @param entity
     * @return the new record id
     */
    int addNewBusiness(BusinessEntity entity);

    /**
     * @param id
     */
    void deleteBusiness(int id);

    /**
     * @param entity 
     */
    void updateBusiness(BusinessEntity entity);

    /**
     * @return 
     */
    List<BusinessInfo> getBusinessInfoList(String keyWord);
    
    
}
