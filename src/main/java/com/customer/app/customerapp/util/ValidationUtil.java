package com.customer.app.customerapp.util;

import com.customer.app.customerapp.Exception.CustomerAppException;
import com.customer.app.customerapp.constant.Constant;
import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class ValidationUtil {


    public static void validate(SaveCustomerDetailsReqDTO reqDTO, HttpServletRequest request) throws CustomerAppException {

        if (reqDTO == null) {
            throw new CustomerAppException(Constant.INVALID_REQUEST,Constant.BAD_REQUEST);
        }
        if (StringUtils.isAnyBlank(reqDTO.getFirstNme(),reqDTO.getDateOfBirth(), reqDTO.getEmail(), reqDTO.getPhone())) {
            throw new CustomerAppException(Constant.SAVE_DETAILS_REQURED_FIEDLSERR_MSG,Constant.BAD_REQUEST);
        }
        validatePhone(reqDTO.getPhone());
        //Validating basic Auth
        authorizedRequest(request, reqDTO.getPhone());
        validateEmail(reqDTO.getEmail());
        validateDateOfBirth(reqDTO.getDateOfBirth());

    }

    public static void validateGetCustomerRequest(CustomerDetailsReqDTO reqDTO, HttpServletRequest request) throws CustomerAppException {
        if (reqDTO == null) {
            throw new CustomerAppException(Constant.INVALID_REQUEST,Constant.BAD_REQUEST);
        }

        if (StringUtils.isAnyBlank(reqDTO.getDateOfBirth(), reqDTO.getEmail(), reqDTO.getPhone())) {
            throw new CustomerAppException(Constant.GET_CUST_DETAILS_REQUIRED_FIELDSERR_MSG,Constant.BAD_REQUEST);
        }
        validatePhone(reqDTO.getPhone());

        //Validating basic Auth
        authorizedRequest(request, reqDTO.getPhone());
        validateEmail(reqDTO.getEmail());
        validateDateOfBirth(reqDTO.getDateOfBirth());
    }

    private static void validatePhone(String phonel) throws CustomerAppException {
        if (StringUtils.isNotBlank(phonel)) {
            if (phonel.length() != 10) {
                throw new CustomerAppException(Constant.PHONE_VALIDATEERR_MSG,Constant.BAD_REQUEST);
            }
        }
    }
    private static void validateEmail(String email) throws CustomerAppException {
        if (StringUtils.isNotBlank(email)) {
            if (!email.contains("@")) {
                throw new CustomerAppException(Constant.INVALID_EMAILERR_MSG,Constant.BAD_REQUEST);
            }
        }
    }
    
    private static void validateDateOfBirth(String dateOfBirth) throws CustomerAppException {
        if (StringUtils.isNotBlank(dateOfBirth)) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_PATTERN);
                LocalDate date = LocalDate.parse(dateOfBirth, formatter);
            }catch (Exception e){
                throw new CustomerAppException(Constant.VALIDATE_DATEERR_MSG,Constant.BAD_REQUEST);
            }
        }
    }

    private static void authorizedRequest(HttpServletRequest request ,String phone) throws CustomerAppException {

        if (!phone.equals(request.getHeader("X-Auth-Header"))){
            throw new CustomerAppException(Constant.AUTH_ERR_MSG,Constant.AUTH_ERR_CODE);
        }
    }

}