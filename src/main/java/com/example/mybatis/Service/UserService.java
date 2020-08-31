package com.example.mybatis.Service;

import com.example.mybatis.entity.Userinfo;
import com.example.mybatis.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Transactional
    public List<Userinfo> selectAll() {
        return userinfoMapper.selectAll();
    }

    /// 新增
    @Transactional
    public int userserviceAdd(Userinfo userinfo) {
        return userinfoMapper.insertSelective(userinfo);
    }
    /// 编辑
    @Transactional
    public int userserviceUpdata(Userinfo userinfo) {
        return userinfoMapper.updateByPrimaryKeySelective(userinfo);
    }

    /// 查-单条
    @Transactional
    public Userinfo userserviceSelectByKey(int id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    /// 删除
    @Transactional
    public int userserviceDelete(int id) {
        return userinfoMapper.deleteByPrimaryKey(id);
    }


}
