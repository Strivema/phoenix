package com.ray.core.exception;

import lombok.Data;

/**
 * @author Marie
 * @date 2020/4/19 12:02 AM
 **/
@Data
public class PhoenixException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public PhoenixException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public PhoenixException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public PhoenixException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public PhoenixException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


}
