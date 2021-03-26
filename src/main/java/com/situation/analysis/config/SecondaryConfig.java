package com.situation.analysis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @description: SecondaryConfig
 * @author: Kobe
 * @date: 2021/3/26 上午10:05
 * @version: v1.0
 */
@Configuration
@MapperScan(
        basePackages = "com.situation.analysis.mapper.secondary",
        sqlSessionFactoryRef = "sqlSessionFactorySecondary",
        sqlSessionTemplateRef = "sqlSessionTemplateSecondary")
public class SecondaryConfig {
    private DataSource secondaryDataSource;

    public SecondaryConfig(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        this.secondaryDataSource = secondaryDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactorySecondary() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(secondaryDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapping/secondary/*.xml"));
        bean.setTypeAliasesPackage("com.situation.analysis.entity.secondary");
        return bean.getObject();
    }

    @Bean("secondaryTransactionManager")
    public DataSourceTransactionManager secondaryTransactionManager() {
        return new DataSourceTransactionManager(secondaryDataSource);
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplateSecondary() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactorySecondary());
    }
}
