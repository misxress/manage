package com.chuangxin.manage.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBean {

    private Integer status;
    private String msg;
    private Object data;

    public static ResponseBean build() {
        return new ResponseBean();
    }

    public static ResponseBean ok(String msg) {
        return new ResponseBean(200, msg, null);
    }

    public static ResponseBean ok(String msg, Object obj) {
        return new ResponseBean(200, msg, obj);
    }

    public static ResponseBean error(ExceptionBean e) {
        return new ResponseBean(e.getCode(), e.getMessage(), null);
    }

    private ResponseBean() {}

    private ResponseBean(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}
