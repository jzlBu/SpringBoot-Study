package com.study.jpajdbctemplate.repository;

import com.study.jpajdbctemplate.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jinzl
 * @title: UserRepository
 * @Package com.study.jpajdbctemplate.repository.UserRepository
 * @ProjectName: SpringBoot-Study
 * @date 2020/3/9
 */

public interface UserRepository extends JpaRepository<SysUser,String> {

    /**
     *
     * 根据jpa自定义查询方法
     * 根据userName查询
     * @param userName
     * @return
     */
    List<SysUser> findByUserName(String userName);

    @Transactional
    @Modifying
    @Query(value = "update sys_user set state = '001' where id in:ids",nativeQuery = true)
    void deleteUpdateSate(@Param("ids") List<String> ids);

    List<SysUser> findTop2ByUserName(String userName);

    void findTop5ByUserName(String userName);
//    List<SysUser> findByAccountAfter

}
