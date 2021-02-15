package com.situation.analysis.db;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @description: DB test
 * @author: Kobe
 * @date: 2021/2/15 下午4:01
 * @version: v1.0
 */
@SpringBootTest
public class DBTest {
    @Resource
    private DataSource dataSource;

    @SneakyThrows
    @Test
    public void testDBConnection() {
        System.out.println(dataSource.getConnection());
    }
}
