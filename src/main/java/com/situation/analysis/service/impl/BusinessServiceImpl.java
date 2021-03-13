package com.situation.analysis.service.impl;

import com.situation.analysis.entity.BusinessEntity;
import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.mapper.BusinessMapper;
import com.situation.analysis.mapper.MonitoringObjectMapper;
import com.situation.analysis.model.BusinessRequest;
import com.situation.analysis.model.BusinessResponse;
import com.situation.analysis.model.ObjectInfo;
import com.situation.analysis.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/13 下午3:22
 * @version: v1.0
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private MonitoringObjectMapper monitoringObjectMapper;

    /**
     * @param request
     * @return the new record id
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addNewBusiness(BusinessRequest request) {
        log.info("start add new business");
        BusinessEntity entity = createEntity(request);
        businessMapper.addNewBusiness(entity);
        int insertId = entity.getId();
        monitoringObjectMapper.batchUpdateMonitoringObject(crateEntities(request.getObjectList(), insertId));
        log.info("insert new business id is : {}", insertId);
    }

    /**
     * @param id
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteBusiness(int id) {
        log.info("delete business id is: {}", id);
        businessMapper.deleteBusiness(id);
        monitoringObjectMapper.unbindObjectWithBusiness(id);
    }

    /**
     * @param request
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateBusiness(BusinessRequest request) {
        businessMapper.updateBusiness(createEntity(request));
        monitoringObjectMapper.batchUpdateMonitoringObject(crateEntities(request.getObjectList(), request.getId()));
    }

    /**
     * @param keyWord
     * @return
     */
    @Override
    public BusinessResponse getBusinessInfoList(String keyWord) {
        log.info("search business info keyword: {}", keyWord);
        BusinessResponse response = new BusinessResponse();
        response.setBusinessInfoList(businessMapper.getBusinessInfoList(keyWord));
        return response;
    }

    private List<MonitoringObjectEntity> crateEntities(List<ObjectInfo> objectList, int bId) {

        return objectList.stream().map(objectInfo -> {
            MonitoringObjectEntity entity = new MonitoringObjectEntity();
            entity.setId(objectInfo.getId());
            entity.setBusinessId(bId);
            entity.setImpactFactor(objectInfo.getImpactFactor());
            return entity;
        }).collect(Collectors.toList());
    }

    private BusinessEntity createEntity(BusinessRequest request) {
        BusinessEntity entity = new BusinessEntity();
        entity.setName(request.getName());
        entity.setRunThreshold(request.getRunThreshold());
        entity.setPlatform(request.getPlatform());
        if (ObjectUtils.isEmpty(request.getId())) {
            entity.setCreatedTime(new Date().toLocaleString());
        } else {
            entity.setId(request.getId());
            entity.setUpdatedTime(new Date().toLocaleString());
        }
        return entity;
    }
}
