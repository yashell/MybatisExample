package com.example.mybatis.controller;


import com.example.mybatis.Service.UserService;
import com.example.mybatis.Service.UserinfoService;
import com.example.mybatis.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MybatisController {

    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUserinfo")
    public Object userinfo() {
        return userService.selectAll();
    }

    /***
     * 保存方法 有id为编辑，没id为新增
     * @param userinfo
     * 请求示例 http://localhost:1111/userinfo/add?name=测试&sex=0&score=295.5
     * id 自增 ，时间后台自动添加
     * @return
     */
    @GetMapping("/userinfo/save")
    // 注意这里的参数写ModelAttribute
    public Object userinfoAdd(@ModelAttribute Userinfo userinfo) {
        if(userinfo.getId() == null){
            userinfo.setTime(new Date());
            return userService.userserviceAdd(userinfo);
        } else {
            userinfo.setTime(null);
            return userService.userserviceUpdata(userinfo);
        }
    }
}
