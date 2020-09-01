package com.example.mybatis.Service;

import com.example.mybatis.entity.Userinfo;
import com.example.mybatis.entity.UserinfoExample;
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
    public List<Userinfo> userinfoSelectAll() {
        UserinfoExample ex = new UserinfoExample();
        UserinfoExample.Criteria cr = ex.createCriteria();
        cr.andNameLike("%" + "哈" + "%");
//        cr.andNameIsNull();
//        ex.setOrderByClause("username asc,email desc");
        return userinfoMapper.selectByExample(ex);
    }


    /***
     * 总数方法
     * @return
     */
    @Transactional
    public long count() {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + "哈" + "%");
        return userinfoMapper.countByExample(example);
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
    
    /// 查-单条-原生sql方法
    @Transactional
    public Userinfo userserviceSelectByKeyNativeSQL(int id) {
        return userinfoMapper.selectBykeyNativeSQL(id);
    }

    /// 删除
    @Transactional
    public int userserviceDelete(int id) {
        return userinfoMapper.deleteByPrimaryKey(id);
    }


}
