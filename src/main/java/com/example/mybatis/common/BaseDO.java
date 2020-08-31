//package com.example.mybatis.common;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableLogic;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.Accessors;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * <pre></pre>
// * <tail> 2020/7/22 10:22 | guanai </tail>
// */
//@Data
//@Accessors(chain = true)
//@EqualsAndHashCode(callSuper = false)
//public abstract class BaseDO implements Serializable {
//
//    /**
//     * id
//     */
//    private @TableId(type = IdType.ASSIGN_ID) String id;
//
//    /**
//     * 逻辑删除
//     */
//    private @TableLogic Boolean isDel;
//
//    /**
//     * 创建时间
//     */
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
//    private LocalDateTime createAt;
//
//    /**
//     * 修改时间
//     */
//
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
//    private LocalDateTime updateAt;
//}
