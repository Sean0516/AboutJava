package com.common.base;

/**
 * @author sean
 * @date 2020/3/23  17:27
 */
public enum Excptions {
    USER_NOT_FOUND(100001L,"user not found ");
    Long code;
    String errorMsg;

    Excptions(Long code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
    public ServiceException exception(){
        return new ServiceException("",this.code,this.errorMsg);
    }
}
