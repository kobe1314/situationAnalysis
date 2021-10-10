package com.situation.analysis.service.impl;

import com.situation.analysis.service.OCRService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @description: ocr implement
 * @author: Kobe
 * @date: 2021/10/9 下午1:46
 * @version: v1.0
 */
@Data
@Slf4j
@Service
@ConfigurationProperties(prefix="ocr")
public class OCRServiceImpl implements OCRService {

    @Resource
    private RestTemplate restTemplate;

    @Value("url")
    private String url;
    
    @Override
    public String get_multiple_items_info(MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };
        form.add("image_file", byteArrayResource);
        form.add("filename", file.getOriginalFilename());
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
        return restTemplate.postForObject(url,files, String.class);
    }
}
