package com.common.user;

import com.common.base.ServiceException;

/**
 * @author sean
 * @date 2020/3/23  16:56
 */

class UserException extends ServiceException {

    UserException(long code, String message, Object data) {
        super("userError", code, message, data);
    }

    UserException(long code, String message) {
        super("userError", code, message);
    }

}
