package com.situation.analysis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.entity.Employee;
import com.situation.analysis.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: ValidateCodeController
 * @author: Kobe
 * @date: 2021/10/17 下午4:45
 * @version: v1.0
 */
@Slf4j
@Validated
@RestController
@ResponseResult
public class ValidateCodeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/logonByCardId")
    public Employee logon(@RequestParam String cardId) {
        log.info("logon type is card, cardId is {}",  cardId);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("CardId",cardId);
        Employee employee = employeeService.getOne(queryWrapper);
        return employee;
    }
}
