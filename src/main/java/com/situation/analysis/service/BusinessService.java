package com.situation.analysis.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description: business service
 * @author: Kobe
 * @date: 2021/10/9 下午1:57
 * @version: v1.0
 */
public interface BusinessService {
    Object deliveryTicket(MultipartFile file, String orderId, String orderNum, String empId) throws IOException;
}
