package com.example.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.entity.fastjsonEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class FastjsonController {

    @ResponseBody
    @RequestMapping("/fastjson")
    public Object helloworld () {

        String txt = "{data:[{name:'Tim',age:25},{name:'Tom',age:28,sex:'male'},{name:'Lily',age:15,sex:'female'}],msg:'转换成功'}";

        // 将一个string型对象转为obj型json
        JSONObject obj = JSON.parseObject(txt);
        // 将这个json其中一部分转为arr型json
        JSONArray recordMap= JSON.parseArray(obj.getString("data").toString());
        // 获取arr型json的长度
        Integer count = recordMap.size();
        // 获取数组中的某一项
        JSONObject listOne =  JSON.parseObject(recordMap.get(0).toString());
        // 获取数组中的某一项的某个字段
        Object listOneName = listOne.getString("name");

        // 将string转为json又转为list 需要建一个实体
        List<fastjsonEntity> list = JSON.parseArray(obj.getString("data").toString(),fastjsonEntity.class);

        return obj ;
    }
}

