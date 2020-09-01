package com.example.mybatis.controller;


import com.example.mybatis.Service.UserService;
import com.example.mybatis.Service.UserinfoService;
import com.example.mybatis.common.Result;
import com.example.mybatis.common.ServerResult;
import com.example.mybatis.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


import static javafx.scene.input.KeyCode.T;

@RestController
public class MybatisController {

    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private UserService userService;

    @GetMapping("/userinfo/all")
    public Object userinfo() {
        List<Userinfo> aa = userService.userinfoSelectAll();
        ServerResult<Object> serverResult = ServerResult.defaultSuccess(aa);
        return serverResult;

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
        int re;
        if(userinfo.getId() == null){
            userinfo.setTime(new Date());
            re = userService.userserviceAdd(userinfo);
        } else {
            userinfo.setTime(null);
            re =  userService.userserviceUpdata(userinfo);
        }
        ServerResult<String> serverResult;
        if(re > 0) {
            serverResult = ServerResult.defaultSuccess(null);
        } else {
            serverResult = ServerResult.defaultFailure();
        }
        return serverResult;
    }

    /**
     * 查单条
     * @param id
     * @return
     * http://localhost:1111/userinfo/selectbykey?id=27
     */
    @GetMapping("/userinfo/selectbykey")
    public Object userinfoSelectByKey(@RequestParam int id) {
        return userService.userserviceSelectByKey(id);
    }


    /***
     * 查单条 -sql
     * @param id
     * @return
     * http://localhost:1111/userinfo/selectbykey-sql?id=27
     */
    @GetMapping("/userinfo/selectbykey-sql")
    public Object userSelectBySQL(@RequestParam int id) {
        Userinfo aa = userService.userserviceSelectByKeyNativeSQL(id);
        ServerResult<Object> serverResult = ServerResult.defaultSuccess(aa);
        return serverResult;
    }

    /***
     * 查单条 -sql-name
     * @param name
     * @return
     * http://localhost:1111/userinfo/selectbyName-sql?name=%E5%93%88
     */
    @GetMapping("/userinfo/selectbyName-sql")
    public Object userSelectBySQL(@RequestParam String name) {
        List<Userinfo> aa = userService.userserviceSelectByNameNativeSQL(name);
        ServerResult<Object> serverResult = ServerResult.defaultSuccess(aa);
        return serverResult;
    }

    /**
     * 删除
     * @param id
     * @return
     * http://localhost:1111/userinfo/delete?id=27
     */
    @GetMapping("/userinfo/delete")
    public int userinfoDelete(@RequestParam int id) {
        return userService.userserviceDelete(id);
    }



}
