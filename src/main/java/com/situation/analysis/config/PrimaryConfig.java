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
 * @description: PrimaryConfig
 * @author: Kobe
 * @date: 2021/3/26 上午10:04
 * @version: v1.0
 */
@Configuration
@MapperScan(
        basePackages = "com.situation.analysis.mapper.primary",
        sqlSessionFactoryRef = "sqlSessionFactoryPrimary",
        sqlSessionTemplateRef = "sqlSessionTemplatePrimary")
public class PrimaryConfig {
    private DataSource primaryDataSource;

    public PrimaryConfig(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        this.primaryDataSource = primaryDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryPrimary() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(primaryDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapping/primary/*.xml"));
        bean.setTypeAliasesPackage("com.situation.analysis.entity");
        return bean.getObject();
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager primaryTransactionManager() {
        return new DataSourceTransactionManager(primaryDataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplatePrimary() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryPrimary());
    }
}
