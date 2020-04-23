package com.config;

import com.common.base.Result;
import com.common.base.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sean
 * @date 2020/3/23  16:39
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(ServiceException e) {
        Result result = e.getResult();
        logger.error("error code [{}] ,error msg [{}]", result.getCode(), result.getMessage());
        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
