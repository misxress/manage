package com.chuangxin.manage.model;

public class ExceptionBean extends RuntimeException{

    private Integer code;
    private String msg;
    
    public ExceptionBean() {}

    public ExceptionBean(ExceptionBeanType type, String message) {
        this.code = type.getCode();
        this.msg = type.getTypeDesc() + '\n' + message;
    }

    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
