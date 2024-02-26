package com.customer.app.customerapp.Exception;


import lombok.Data;

@Data
public class CustomerAppException extends Exception{

    private String message;
    private Integer code;
    public CustomerAppException() {}

    public CustomerAppException(String msg, Integer code)
    {
        super(msg);
        this.message = msg;
        this.code = code;
    }

}
