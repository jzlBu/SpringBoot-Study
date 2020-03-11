package com.study.jpajdbctemplate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author jinzl
 * @title: SysRole
 * @Package com.jinzl.demo.entity
 * @ProjectName: springboot_demo0221
 * @date 2020/2/24
 */

@Entity
@Table(name = "sys_role", schema = "my_database")
public class SysRole {
    private String roleId;

    @Id
    @Column(name = "role_id", nullable = false, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRole sysRole = (SysRole) o;
        return Objects.equals(roleId, sysRole.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }
}
