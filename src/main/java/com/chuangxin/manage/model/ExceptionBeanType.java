package com.chuangxin.manage.model;

public enum ExceptionBeanType {

    USER_INPUT_ERROR(400,"用户输入异常"),
    SYSTEM_ERROR (500,"系统服务异常"),
    OTHER_ERROR(999,"其他未知异常");

    private final String typeDesc;//异常类型中文描述

    private final int code; //code

    ExceptionBeanType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }
}
