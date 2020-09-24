package com.example.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangshi
 * @since 2020-09-06
 */
@TableName("userinfo")
@ApiModel(value = "用户表",description = "实体名为UserinfoPlus")
public class UserinfoPlus implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value="用户ID(新增填null,编辑填写id)",required=false,name="id",example="0")

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="用户姓名",required=true,name="name",example="张三")
    @TableField("name")
    private String name;

    @ApiModelProperty(value="性别(女:true,男:false)",required=true,name="sex",example="true")
    @TableField("sex")
    private Boolean sex;

    @ApiModelProperty(value="分数",required=true,name="score",example="100.00")
    @TableField("score")
    private Float score;

    @ApiModelProperty(value="时间(填null或不写这个参数，由后台生成)",hidden=true,name="time",example="")
    @TableField("time")
    private LocalDateTime time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
            "id=" + id +
            ", name=" + name +
            ", sex=" + sex +
            ", score=" + score +
            ", time=" + time +
        "}";
    }
}
