package com.situation.analysis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situation.analysis.entity.MonitoringObjectEntity;
import com.situation.analysis.mapper.IndicatorMapper;
import com.situation.analysis.mapper.MonitoringObjectMapper;
import com.situation.analysis.model.*;
import com.situation.analysis.service.ObjectService;
import com.situation.analysis.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: impl
 * @author: Kobe
 * @date: 2021/3/12 上午8:27
 * @version: v1.0
 */
@Slf4j
@Service
public class ObjectServiceImpl implements ObjectService {

    @Resource
    private MonitoringObjectMapper monitoringObjectMapper;

    @Resource
    private IndicatorMapper indicatorMapper;

    /**
     * add object
     *
     * @param request
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addObject(MonitoringObjectRequest request) {

        //String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = "";
        //if (!StringUtils.isEmpty(token)) {
        //    username = JwtUtil.getUsernameFromToken(token);
        //}
        MonitoringObjectEntity objectEntity = createObjectEntity(request, username);
        monitoringObjectMapper.addMonitoringObject(objectEntity);
        int insertId = objectEntity.getId();
        log.info("adding object id is {}", insertId);

        List<IndicatorInformation> iList = request.getIndicatorInformationList();
        iList.stream().forEach(indicator -> {
            indicator.setObjectId(insertId);
        });
        indicatorMapper.batchUpdateIndicator(iList);
        log.debug("finish add object");
    }

    /**
     * @param id
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteObject(int id) {
        log.info("delete object id: {}", id);
        monitoringObjectMapper.deleteMonitoringObject(id);
        indicatorMapper.updateIndicate(id);
        log.info("finished delete object ");

    }

    /**
     * @param request
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateObject(MonitoringObjectRequest request) {
        String username = "";
        MonitoringObjectEntity objectEntity = createObjectEntity(request, username);
        monitoringObjectMapper.updateMonitoringObject(objectEntity);
        log.info("finished update object ");

        List<IndicatorInformation> iList = request.getIndicatorInformationList();
        iList.stream().forEach(indicator -> {
            indicator.setObjectId(request.getId());
        });
        indicatorMapper.batchUpdateIndicator(iList);
    }

    /**
     * @return
     */
    @Override
    public PageResult<MonitoringObjectInfo> getMonitoringObjectList(String keyWord,int pageNum, int pageSize) {
        log.info("search object keyWord: {}", keyWord);
        PageHelper.startPage(pageNum, pageSize);
        List<MonitoringObjectInfo> list = monitoringObjectMapper.selectObjectList(keyWord);
        return PageUtil.getPageResult(new PageInfo<MonitoringObjectInfo>(list));
    }

    /**
     * @return
     */
    @Override
    public List<Option> getObjectOptionList() {
        log.info("start object option list");
        return monitoringObjectMapper.getObjectOptionList();
    }

    private MonitoringObjectEntity createObjectEntity(MonitoringObjectRequest request, String username) {
        MonitoringObjectEntity objectEntity = new MonitoringObjectEntity();
        objectEntity.setName(request.getObjectName());
        objectEntity.setRunThreshold(request.getRunThreshold());
        objectEntity.setLevelId(request.getLevelId());

        if (ObjectUtils.isEmpty(request.getId())) {
            objectEntity.setCreatedBy(username);
            objectEntity.setCreatedTime(new Date().toLocaleString());
        } else {
            objectEntity.setId(request.getId());
            objectEntity.setUpdatedBy(username);
            objectEntity.setUpdatedTime(new Date().toLocaleString());
        }

        return objectEntity;
    }
}
