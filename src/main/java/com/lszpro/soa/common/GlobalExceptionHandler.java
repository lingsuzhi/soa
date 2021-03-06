package com.lszpro.soa.common;

 
import com.lszpro.soa.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

 

/**
 * 全局Exception处理
 *
 * @author lijun <ljun51@outlook.com>
 * @create 2017-03-29 2:59 PM
 * @since 1.0.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handle(Exception e) {
        LOGGER.error("{}", e);
        BodyStatus bodyStatus;
        if (e instanceof ServiceException) {
            bodyStatus = ((ServiceException) e).getBodyStatus();
            LOGGER.warn(bodyStatus.getMessage() + e);
            return new ResponseEntity<>(bodyStatus, HttpStatus.OK);

        }
        if (e instanceof HttpRequestMethodNotSupportedException) {
            bodyStatus = Utils.bodyStatus("4005","");
            LOGGER.warn(bodyStatus.getMessage() + e);
            return new ResponseEntity<>(bodyStatus, HttpStatus.OK);

        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            bodyStatus = Utils.bodyStatus("4011","");
            LOGGER.error(bodyStatus.getMessage() + e);
            return new ResponseEntity<>(bodyStatus, HttpStatus.OK);

        } else if (e instanceof HttpMessageNotReadableException) {
            bodyStatus = Utils.bodyStatus("4004","");
            LOGGER.error(bodyStatus.getMessage() + e);
            return new ResponseEntity<>(bodyStatus, HttpStatus.OK);

        } else if (e instanceof NumberFormatException) {
            bodyStatus = Utils.bodyStatus("4008","");
            LOGGER.error(bodyStatus.getMessage() + e);
            return new ResponseEntity<>(bodyStatus, HttpStatus.OK);

 //       } else if (e instanceof MethodArgumentNotValidException) {
//            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
//            if (bindingResult.hasErrors() && bindingResult.hasFieldErrors()) {
//                FieldError fieldError = bindingResult.getFieldError();
//                BodyValidStatus bodyValidStatus = new BodyValidStatus.Builder()
//                        .code(4006)
//                        .message(fieldError.getDefaultMessage())
//                        .field(fieldError.getField())
//                        .build();
//                LOGGER.warn(bodyValidStatus.getMessage() + e);
//                return new ResponseEntity<>(bodyValidStatus, HttpStatus.OK);
//            } else {
//                bodyStatus = Utils.bodyStatus(4006);
//                LOGGER.error(bodyStatus.getMessage() + e);
//                return new ResponseEntity<>(bodyStatus, HttpStatus.OK);
//            }

        } else {
            bodyStatus = Utils.bodyStatus("5000","未知异常");
            LOGGER.error(bodyStatus.getMessage() + e);
            return new ResponseEntity<>(bodyStatus, HttpStatus.OK);
        }
    }
}
