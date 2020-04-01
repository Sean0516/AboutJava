package com.common.user;

/**
 * @author sean
 * @date 2020/3/23  16:21
 */
public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
        super(UserErrorCodes.USER_NOT_FOUND, "UserNotFound");
    }

    public UserNotFoundException(String message, Object data) {
        super(UserErrorCodes.USER_NOT_FOUND, message, data);
    }

    public UserNotFoundException(String message) {
        super(UserErrorCodes.USER_NOT_FOUND, message);
    }
}
