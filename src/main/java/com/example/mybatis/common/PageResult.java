package com.example.mybatis.common;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "返回分页结果实体",description = "")
public class PageResult<T> implements Serializable {
    @ApiModelProperty(value="当前第几页",required=true,name="current",example = "1")
    private Integer current;
    @ApiModelProperty(value="每页有多少条数据",required=true,name="size",example = "10")
    private Integer size;
    @ApiModelProperty(value="总共有多少条数据",required=true,name="total")
    private Long total;

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    private T list;


    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
