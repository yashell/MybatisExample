package com.example.mybatis.Service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis.Service.UserinfoService;
import com.example.mybatis.common.PageResult;
import com.example.mybatis.mapper.UserinfoMapperPlus;
import com.example.mybatis.model.UserinfoPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoServiceImpl implements UserinfoService {

//    @Autowired
//    private UserinfoMapper userinfoMapper;
//
//    @Override
//    public List<Userinfo> getAllUserinfo() {
//        return userinfoMapper.selectAll();
//    }
//
//    public Userinfo selectByPrimaryKey() {
//        return userinfoMapper.selectByPrimaryKey(2);
//    }

    @Autowired
    private UserinfoMapperPlus userinfoMapperPlus;


    /**
     * 查单条
     * @param id
     * @return
     */
    public UserinfoPlus selectById(int id) {
        return userinfoMapperPlus.selectById(id);
    }

    /**
     * 查列表
     * @param current
     * @param size
     * @param name
     * @return
     */
    public PageResult userAll (int current , int size , String name) {
        IPage<UserinfoPlus> userPage = new Page<>(current, size);
        userPage = userinfoMapperPlus.selectPage(userPage,new QueryWrapper<UserinfoPlus>()
                .like("name", name)
        );
        List<UserinfoPlus> list = userPage.getRecords();
        PageResult pageResult = new PageResult();
        pageResult.setCurrent(current);
        pageResult.setSize(size);
        pageResult.setTotal(userPage.getTotal());
        pageResult.setList(userPage.getRecords());
        return pageResult;
    }


    public int save(UserinfoPlus userinfoPlus) {

        return userinfoMapperPlus.insert(userinfoPlus);
    }

}
