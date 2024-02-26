package com.customer.app.customerapp.constant;

public class Constant {


    public static final String INVALID_REQUEST = "Invalid Request";
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAILURE_CODE = 500;
    
    
    public static final Integer BAD_REQUEST = 400;
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    public static final String FAILURE_MESSAGE = "FAILED";
    public static final String SAVE_DETAILS_REQURED_FIEDLSERR_MSG = "Required Fields are null provide [firstName,phone,dateOfBirth,email]";
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String VALIDATE_DATEERR_MSG = "Invalid date of birth. Please provide with formate [dd/MM/yyyy]";
    public static final String GET_CUST_DETAILS_REQUIRED_FIELDSERR_MSG = "Required Fields are null provide [phone,dateOfBirth,email]";
    public static final String PHONE_VALIDATEERR_MSG = "Phone number should be 10 digits.";
    public static final String INVALID_EMAILERR_MSG = "Invalid email id.";
    public static final String AUTH_ERR_MSG = "Not Authorized please pass header [X-Auth-Header]. (For testing apis please pass your phone as header value.)";
    public static final Integer AUTH_ERR_CODE = 403;
    public static final String GENERIC_ERR_MSG = "Something went wrong, Please try again later !!!";
    public static final String CUSTOMER_NOT_FOUND = "Customer not found!.";
    public static final String CUSTOMER_SAVED = "Customer successfully saved.";
    ;

    public Constant() {
    }
}
