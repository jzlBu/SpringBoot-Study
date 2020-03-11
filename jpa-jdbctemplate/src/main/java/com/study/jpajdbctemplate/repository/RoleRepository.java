package com.study.jpajdbctemplate.repository;

import com.study.jpajdbctemplate.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jinzl
 * @title: RoleRepository
 * @Package com.study.jpajdbctemplate.repository
 * @ProjectName: SpringBoot-Study
 * @date 2020/3/9
 */
public interface RoleRepository extends JpaRepository<SysRole,String> {
}
