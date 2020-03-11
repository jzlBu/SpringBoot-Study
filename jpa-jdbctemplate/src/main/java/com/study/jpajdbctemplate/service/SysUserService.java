package com.study.jpajdbctemplate.service;

import com.study.jpajdbctemplate.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author jinzl
 * @title: SysUserService
 * @Package com.jinzl.demo.service
 * @ProjectName: springboot_demo0221
 * @date 2020/2/21
 */

public interface SysUserService{

    /**
     * jpa保存数据
     * @param sysUser
     */
    void save(SysUser sysUser);

    /**
     * jpa根据userName查询
     * @param userName
     * @return
     */
    List<SysUser> findByUserName(String userName);
    /**
     * jpa根据userName查询两条
     * @param userName
     * @return
     */
    List<SysUser> findTopByUserName(String userName);

    /**
     * jpa更新数据
     * @param sysUser
     * @return
     */
    void update(SysUser sysUser);

    /**
     * jpa删除数据
     * @param id
     */
    void delete(String id);

    /**
     * jdbc添加数据
     * @param sysUser
     */
    void saveJdbcTemplate(SysUser sysUser);

    /**
     * jdbc根据用户名查询数据
     * @param userName
     * @return
     */
    SysUser findByUserNameJdbc(String userName) ;

    /**
     * jdbc根据用户名查询数据
     * @param userName
     * @return
     */
    SysUser findByUser(String userName);


    List<Map<String, Object>> findByUserList(String userName);

    Map<String,Object> map(String map);


}
