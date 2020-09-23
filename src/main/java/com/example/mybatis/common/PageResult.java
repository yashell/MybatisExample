package com.example.mybatis.common;
import java.io.Serializable;

public class PageResult<T> implements Serializable {
    private Integer current;
    private Integer size;
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
