package com.postgresql.postgresql.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import com.alibaba.druid.pool.DruidDataSource;
@Slf4j
public class Postgres {


  private static DruidDataSource createJdbcTemplate() {
    log.info("-----Creating postGisJdbcTemplate Bean-----");
    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setUrl("jdbc:postgresql://localhost:5432/targettingframework");
    dataSource.setUrl("jdbc:postgresql://localhost:5433/targettingframework");
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUsername("postgres");
    dataSource.setPassword("Oie3aczhmcHi7ZDdZ8dKBXD2OSJPmuSLGNNA14gFi4Hvr5pmrmacrz1hDsBV0SBK");

    dataSource.setDefaultAutoCommit(false);
    dataSource.setMaxActive(50);
    dataSource.setTestOnBorrow(true);
    dataSource.setTestOnReturn(false);
    dataSource.setTestWhileIdle(true);
    dataSource.setMaxWait(10000);
    dataSource.setValidationQuery("SELECT 1");
    dataSource.setValidationQueryTimeout(5);
    dataSource.setInitialSize(1);
    dataSource.setConnectionErrorRetryAttempts(3);
    dataSource.setPoolPreparedStatements(true);
    dataSource.setUseOracleImplicitCache(false); // This is for oracle cache, not applicable to postgresql
    dataSource.setMinIdle(1);
    dataSource.setMinEvictableIdleTimeMillis(30000);
    dataSource.setTimeBetweenEvictionRunsMillis(5000);
    dataSource.setRemoveAbandoned(true);
    dataSource.setRemoveAbandonedTimeout(300);
    dataSource.setLogAbandoned(true);
    return dataSource;
  }

  @Bean
  private JdbcTemplate postGisJdbcTemplate() {
    log.info("-----Creating postGisJdbcTemplate Bean-----");
    return new JdbcTemplate(createJdbcTemplate());
  }

}
