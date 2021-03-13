package com.situation.analysis.service;

import com.situation.analysis.entity.BusinessEntity;
import com.situation.analysis.model.BusinessInfo;
import com.situation.analysis.model.BusinessRequest;
import com.situation.analysis.model.BusinessResponse;

import java.util.List;

/**
 * @description: Business Service
 * @author: Kobe
 * @date: 2021/3/13 下午3:14
 * @version: v1.0
 */
public interface BusinessService {
    /**
     * @param request
     * @return the new record id
     */
    void addNewBusiness(BusinessRequest request);

    /**
     * @param id
     */
    void deleteBusiness(int id);

    /**
     * @param request
     */
    void updateBusiness(BusinessRequest request);

    /**
     * @return
     */
    BusinessResponse getBusinessInfoList(String keyWord);
}
