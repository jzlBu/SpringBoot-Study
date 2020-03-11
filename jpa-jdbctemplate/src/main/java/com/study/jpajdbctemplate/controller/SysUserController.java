package com.study.jpajdbctemplate.controller;

import com.study.jpajdbctemplate.entity.SysUser;
import com.study.jpajdbctemplate.service.SysUserService;
import com.study.jpajdbctemplate.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author jinzl
 * @title: SysUserController
 * @Package com.jinzl.demo.controller
 * @ProjectName: springboot_demo0221
 * @date 2020/2/21
 */

@Controller
//@RequestMapping(value = "/sys/user/")//请求映射路径
@ResponseBody
public class SysUserController extends  BaseController{

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("save")
    public String saveUser(SysUser sysUser) {
//        String name = request.getParameter("userName");
//        System.out.println(name);
//        sysUser.setAccount(request.getParameter("account"));
//        sysUser.setUserName(request.getParameter("userName"));
        sysUserService.save(sysUser);
        return "success";
    }

    @PostMapping("list")
    public List<SysUser> list() {
        String userName = request.getParameter("userName");
        List<SysUser> list = sysUserService.findByUserName(userName);
        for (SysUser sysUser:list){
            System.out.println(sysUser.getId());
        }
        return list;
    }

    @PostMapping("list2")
    public List<SysUser> list2() {
        String userName = request.getParameter("userName");
        List<SysUser> list = sysUserService.findTopByUserName(userName);
        for (SysUser sysUser:list){
            System.out.println(sysUser.getId());
        }
        return list;
    }


    @PostMapping("update")
    public String update(SysUser sysUser) {
        sysUserService.update(sysUser);
        return "success";
    }

    @PostMapping("delete")
    public String delete(String id) {
        sysUserService.delete(id);
        return "success";
    }

    @PostMapping("saveJdbc")
    public Result<Object> saveJdbcTemplate(SysUser sysUser) {
        sysUserService.saveJdbcTemplate(sysUser);
        return Result.success("添加成功");
    }

    @PostMapping("listJdbc")
    @ResponseBody
    public SysUser listJdbc(@RequestParam String userName) {
        return sysUserService.findByUserNameJdbc(userName);
    }

    @PostMapping("listJdbcObject")
    public SysUser listJdbcForObject(String userName) {
        return sysUserService.findByUser(userName);
    }

    @PostMapping("userList")
    public List<Map<String, Object>> userList(String userName) {
        return sysUserService.findByUserList(userName);
    }

    @PostMapping("map")
    public Map<String,Object> map(String userName) {
        return sysUserService.map(userName);
    }

    @PostMapping("test")
    public String test() {
        return "success";
    }
}
