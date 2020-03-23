package com.common.user;

import com.common.base.BaseErrorCode;
import com.common.base.ServiceException;

/**
 * @author sean
 * @date 2020/3/23  15:50
 */
class UserErrorCodes {
    static final long USER_NOT_FOUND = BaseErrorCode.USER_BASE_CODE + 1L;
    static final long USER_PASSWORD_ERROR = BaseErrorCode.USER_BASE_CODE + 2L;
    static final long USER_UNKNOW_EXCEPTION = BaseErrorCode.USER_BASE_CODE + 99L;

}
