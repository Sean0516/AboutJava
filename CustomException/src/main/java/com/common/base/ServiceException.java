package com.common.base;

/**
 * @author sean
 * @date 2020/3/23  15:30
 */
public class ServiceException extends RuntimeException {
    private Result result;

    public ServiceException(String description) {
        super(description);
        this.result = new Result();
    }

    public ServiceException(String description, long code, String message, Object data) {
        super(description);
        this.result = new Result(code, message, false, data);
    }

    public ServiceException(String description, long code, String message) {
        super(description);
        this.result = new Result(code, message, false);
    }

    public Result getResult() {
        return result;
    }
}
