package com.example.mybatis.controller;


import com.example.mybatis.Service.Impl.UserinfoServiceImpl;
import com.example.mybatis.common.PageResult;
import com.example.mybatis.common.ServerResult;
import com.example.mybatis.model.UserinfoPlus;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangshi
 * @since 2020-09-06
 */
@Api(description = "用户表的相关接口")
@RestController
@RequestMapping("/plus/user")
public class MybatisPlusController {
    @Autowired
    private UserinfoServiceImpl userinfoServicePlus;

    @PostMapping("/helloworld")
    @ApiOperation(value="测试传实体且返回实体", notes="这里边填写备注，用户可仔细阅读")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
//    @ApiImplicitParam(name="userinfoPlus",value="userinfoPlus实体",required=true,paramType="path")
    public Object helloworld (@RequestBody UserinfoPlus userinfoPlus)
    {
        return "fds";
    }

    /**
     * 查单条
     * @param id
     * @return
     * http://localhost:1111/plus/user/selectbyid?id=27
     */
    @GetMapping("/selectbyid")
    public Object userinfoSelectByKey(@RequestParam int id) {
        UserinfoPlus userinfoPlus = userinfoServicePlus.selectById(id);
        ServerResult<Object> serverResult = ServerResult.defaultSuccess(userinfoPlus);
        return serverResult;
    }

    /***
     * 查列表
     * @param current 当前第几页 默认 1
     * @param size 每页多少条信息 默认 10
     * @param name 姓名
     * http://localhost:1111/plus/user/all?size=10&current=1&name=%E5%93%88
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value="获取用户列表", notes="这里边填写备注，用户可仔细阅读")
    @ApiImplicitParams({
            @ApiImplicitParam(name="current",defaultValue="1",value="当前第几页",required=false,paramType="path",dataType="Integer"),
            @ApiImplicitParam(name="size",defaultValue="10",value="每页多少条数据",required=false,paramType="path",dataType="Integer"),
            @ApiImplicitParam(name="name",defaultValue="",value="查询的姓名",required=false,paramType="path",dataType="String"),
    })

    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })

    public Object queryList(@RequestParam(value="current",defaultValue="1") Integer current, @RequestParam(value="size",defaultValue="10") Integer size , @RequestParam(value="name",defaultValue="") String name) {
        PageResult pageResult = userinfoServicePlus.userAll(current,size, name);
        ServerResult<Object> serverResult = ServerResult.defaultSuccess(pageResult);
        return serverResult;
    }
}
