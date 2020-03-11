package com.study.jpajdbctemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jinzl
 * @title: BaseController
 * @Package com.jinzl.demo.controller
 * @ProjectName: springboot_demo0221
 * @date 2020/2/21
 */

public class BaseController<T> {

    @Autowired
    protected HttpServletRequest request;

}
