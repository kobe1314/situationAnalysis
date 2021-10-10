package com.situation.analysis.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description: OCR service
 * @author: Kobe
 * @date: 2021/10/6 下午3:44
 * @version: v1.0
 */
public interface OCRService {
    String get_multiple_items_info(MultipartFile file) throws IOException, IOException;
}
