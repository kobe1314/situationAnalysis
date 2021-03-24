package com.situation.analysis.controller;

import com.situation.analysis.model.NoticeRequest;
import com.situation.analysis.model.NoticeResponse;
import com.situation.analysis.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: notice
 * @author: Kobe
 * @date: 2021/3/23 下午9:05
 * @version: v1.0
 */
@Slf4j
@RestController
public class NoticeController {

    @Resource
    NoticeService NoticeService;

    @PostMapping("/api/data_notify")
    public NoticeResponse noticeUpdated(@RequestBody NoticeRequest request) {
        log.debug("start notice updated");
        NoticeResponse response = new NoticeResponse();
        NoticeService.updateInformation(request);
        return response;
    }
}
