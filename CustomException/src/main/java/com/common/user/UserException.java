package com.common.user;

import com.common.base.ServiceException;

/**
 * @author sean
 * @date 2020/3/23  16:18
 */
public class UserException extends ServiceException {

    public UserException(long code, String message, Object data) {
        super("userError", code, message, data);
    }
    public UserException(long code, String message) {
        super("userError", code, message);
    }


}
