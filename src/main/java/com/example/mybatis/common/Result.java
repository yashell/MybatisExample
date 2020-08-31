package com.example.mybatis.common;



import static com.example.mybatis.common.CodeMsg.SUCCESS;
import static com.example.mybatis.common.CodeMsg.*;

/**
 * <pre></pre>
 * <tail> 2020/7/22 10:54 | guanai </tail>
 */

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result() {
    }
    private Result(int code, String msg,T data) {
        this.code=code;
        this.msg=msg;
        this.data = data;
    }

    public static <T> Result<T> ok(){
        return build(SUCCESS,null);
    }

    public static <T> Result<T> ok(T data){
        return build(SUCCESS,data);
    }

    public static <T> Result<T> fail(){
        return build(FAIL,null);
    }

    public static <T> Result<T> fail(CodeMsg cm){
        return build(cm);
    }

    public static <T> Result<T> err(){
        return build(SERVER_ERROR,null);
    }

    public static <T> Result<T> build(boolean res){
        return res?ok():fail();
    }

    public static <T> Result<T> build(CodeMsg cm){
        return build(cm,null);
    }

    public static <T> Result<T> build(CodeMsg cm, T data){
        return new Result<>(cm.getCode(),cm.getMsg(),data);
    }
}
