package com.study.jpajdbctemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author jinzl
 * @title: BaseService
 * @Package com.jinzl.demo.service
 * @ProjectName: springboot_demo0221
 * @date 2020/2/22
 */

public class BaseService{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String id;

    public String getUuid() {
        return  jdbcTemplate.queryForObject("SELECT REPLACE(UUID(),'-','') as uuid",String.class);
    }




}
