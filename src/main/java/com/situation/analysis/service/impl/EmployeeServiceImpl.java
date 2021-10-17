package com.situation.analysis.service.impl;

import com.situation.analysis.entity.Employee;
import com.situation.analysis.mapper.EmployeeMapper;
import com.situation.analysis.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kobe
 * @since 2021-10-17
 */
@Slf4j
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
