package com.example.mybatis.mapper;

import com.example.mybatis.model.Userinfo;
import com.example.mybatis.model.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserinfoMapper {
    long countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExample(UserinfoExample example);

    @Select("select id, name, sex, score, time from userinfo where id = #{id}")
    Userinfo selectBykeyNativeSQL(int id);

    @Select("select id, name, sex, score, time from userinfo where name like concat('%',#{name},'%')")
    List<Userinfo> selectByNameNativeSQL(String name);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}