package com.study.jpajdbctemplate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;

/**
 * @author jinzl
 * @title: SysUser
 * @Package com.jinzl.demo.entity
 * @ProjectName: springboot_demo0221
 * @date 2020/2/24
 */

@Entity
@Table(name = "sys_user", schema = "my_database")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysUser {
    private String id;
    private String account;
    private String userName;
    private String state;


    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account", nullable = true, length = 10)
//    @Email(message = "邮箱地址不合法")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 10)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 3)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state==null || state==""){
            state ="000";
        }
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) &&
                Objects.equals(account, sysUser.account) &&
                Objects.equals(userName, sysUser.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, userName);
    }
}
