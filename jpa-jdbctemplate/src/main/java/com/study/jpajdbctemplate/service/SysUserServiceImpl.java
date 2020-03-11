package com.study.jpajdbctemplate.service;

import antlr.StringUtils;

import com.study.jpajdbctemplate.entity.SysUser;
import com.study.jpajdbctemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author jinzl
 * @title: SysUserService
 * @Package com.jinzl.demo.service
 * @ProjectName: springboot_demo0221
 * @date 2020/2/21
 */

@Service("sysUserService")
public class SysUserServiceImpl extends BaseService implements SysUserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;

    /**
     * jpa添加用户
     * @param sysUser
     */
    @Override
    public void save(SysUser sysUser) {
        userRepository.save(sysUser);
    }

    /**
     * jpa根据userName查询
     * @param userName
     * @return
     */
    @Override
    public List<SysUser> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    /**
     * jpa根据userName查询两条
     * @param userName
     * @return
     */
    @Override
    public List<SysUser> findTopByUserName(String userName) {
        return userRepository.findTop2ByUserName(userName);
    }

    @Override
    public void update(SysUser sysUser) {
        Optional<SysUser> optional = userRepository.findById(sysUser.getId());
        SysUser user = optional.get();
        if (sysUser.getState()==null){
            sysUser.setState(user.getState());
        }
        userRepository.save(sysUser);
    }

    @Override
    public void delete(String id) {
        Optional<SysUser> optional = userRepository.findById(id);
        SysUser sysUser = optional.get();
        sysUser.setState("001");
        userRepository.save(sysUser);
    }

    /**
     * jdbc添加数据
     * @param sysUser
     */
    @Override
    public void saveJdbcTemplate(SysUser sysUser) {
        String sql = "insert into sys_user (id,account,userName) values(?,?,?)";
        int result = jdbcTemplate.update(sql, getUuid(),sysUser.getAccount(),sysUser.getUserName());
        if (result>0){
            System.out.println("数据添加成功");
        }
    }

    /**
     * jdbc查询数据query
     * @param userName
     * @return
     */
    @Override
    public SysUser findByUserNameJdbc(String userName)  {
        String sql = "select * from sys_user where userName = ? ";

            List<SysUser> userList = jdbcTemplate.query(sql,new Object[]{userName},new BeanPropertyRowMapper<>(SysUser.class));
            if (userList!=null) {
                return userList.get(0);
            }else {
                return null;
            }

//        1.
//        List userList = jdbcTemplate.query (sql,new Object[]{userName}, new RowMapper<Map>() {
//            @Override
//            public Map mapRow(ResultSet resultSet, int i) throws SQLException {
//                Map map = new HashMap();
//                map.put("userName",resultSet.getString("userName"));
//                return map;
//            }
//        });
//        2.
//        List result = jdbcTemplate.query(sql, new Object[]{userName}, new ResultSetExtractor<List>() {
//            @Override
//            public List extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                List result = new ArrayList();
//                Map map = new HashMap();
//                while (resultSet.next()){
//                    map.put("userName",resultSet.getString("userName"));
//                    result.add(map);
//                }
//                return result;
//            }
//        });
//        return null;
    }

    @Override
    public SysUser findByUser(String userName) {
        String sql = "select * from sys_user where userName = ? ";
        SysUser sysUser = jdbcTemplate.queryForObject(sql,new Object[]{userName}, new RowMapper<SysUser>() {
            @Override
            public SysUser mapRow(ResultSet resultSet, int i) throws SQLException {
                SysUser user = new SysUser();
                user.setUserName(resultSet.getString("userName"));
                user.setAccount("****");
                return user;
            }
        });
        return sysUser;
    }

    @Override
    public List<Map<String, Object>> findByUserList(String userName) {
        String sql = "select * from sys_user where userName = ? ";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql,userName);
        return userList;
    }

    @Override
    public Map<String,Object> map(String userName) {
        String sql = "select * from sys_user where userName = ? ";
        Map<String,Object> map = jdbcTemplate.queryForMap(sql,userName);
        return map;
    }
}
