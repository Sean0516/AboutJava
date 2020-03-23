package com.common.user;

/**
 * @author sean
 * @date 2020/3/23  16:21
 */
public class UserNnKnownException extends UserException {
    public UserNnKnownException() {
        super(UserErrorCodes.USER_UNKNOW_EXCEPTION, "UserUnknowException");
    }

    public UserNnKnownException(String message, Object data) {
        super(UserErrorCodes.USER_UNKNOW_EXCEPTION, message, data);
    }
    public UserNnKnownException(String message) {
        super(UserErrorCodes.USER_UNKNOW_EXCEPTION, message);
    }
}
