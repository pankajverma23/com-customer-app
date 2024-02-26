package com.customer.app.customerapp.Exception;

import com.customer.app.customerapp.constant.Constant;
import com.customer.app.customerapp.dto.resp.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handle(Exception ex){
        BaseResponse errorResponse = new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constant.GENERIC_ERR_MSG);
        return ResponseEntity.ok(errorResponse);
    }

}
