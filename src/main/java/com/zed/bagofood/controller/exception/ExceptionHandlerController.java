package com.zed.bagofood.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 */
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Exception")
    @ExceptionHandler({Exception.class})
    public String handleException(Exception exception) {
        logger.error("[handleException] " + exception.getMessage());
        return "Exception";
    }

}
