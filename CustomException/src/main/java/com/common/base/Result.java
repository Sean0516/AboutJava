package com.common.base;

/**
 * @author sean
 * @date 2020/3/23  15:31
 */
public class Result<T> {
    private long code;
    private String message;
    private boolean success;
    private T data;

    public Result() {
    }

    public Result(String message) {
        this.message = message;
        this.success = true;
    }

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public Result(long code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public Result(long code, String message, boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
