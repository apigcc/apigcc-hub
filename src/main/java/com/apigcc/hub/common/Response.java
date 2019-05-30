package com.apigcc.hub.common;

import lombok.Data;

@Data
public class Response<T> {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = 1;
    public static final String MSG_SUCCESS = "success";

    int code;
    String msg;
    T data;

    public static Response success(){
        Response resp = new Response<>();
        resp.setCode(CODE_SUCCESS);
        resp.setMsg(MSG_SUCCESS);
        return resp;
    }

    public static <T> Response<T> success(T data){
        Response<T> resp = new Response<>();
        resp.setCode(CODE_SUCCESS);
        resp.setMsg(MSG_SUCCESS);
        resp.setData(data);
        return resp;
    }

    public static <T> Response<T> fail(String msg) {
        Response<T> resp = new Response<>();
        resp.setCode(CODE_FAIL);
        resp.setMsg(msg);
        return resp;
    }

    public boolean ok(){
        return CODE_SUCCESS == code;
    }
}
