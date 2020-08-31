//package com.example.mybatis.common;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.Serializable;
//
///**
// * <pre></pre>
// * <tail> 2020/7/22 10:42 | guanai </tail>
// */
//public abstract class BaseController<M extends ServiceImpl<? extends BaseMapper<T>, T>,T> {
//
//    @Autowired M service;
//
////    @GetMapping({"","/"})
////    public Result<?> list(){
////        return Result.ok(service.list());
////    }
//
//    @ApiOperation("根据Id查询")
//    @GetMapping("/{id}")
//    public Result<?> getById(@PathVariable Serializable id){
//        return Result.ok(service.getById(id));
//    }
//
//    @PostMapping("/saveOrUpdate")
//    @ApiOperation("新增实体")
//    @ApiImplicitParam(name = "t", value = "实体对象t", dataType = "T",type = "json", required = true)
//    public Result<?> saveOrUpdate(@RequestBody T t){
//        return Result.build(service.saveOrUpdate(t));
//    }
//
//    @ApiOperation("删除")
//    @DeleteMapping ("/remove/{id}")
//    public Result<?> removeById(@PathVariable Serializable id){
//        return Result.ok(service.removeById(id));
//    }
//
//}
