package com.example.mybatis.common;

/**
 * <pre></pre>
 * <tail> 2020/7/22 10:56 | guanai </tail>
 */
public enum CodeMsg {
    SERVER_ERROR(500,"服务器发生错误！"),
    SUCCESS(200,"成功！"),
    FAIL(400,"失败！"),
    SIGN_IN(406,"请登录"),
    USERNAME_NOT_EXIST(401,"用户名不存在！"),
    BAD_CREDENTIALS(402,"用户名或密码错误！");

    private final Integer code;
    private final String msg;

    CodeMsg(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
