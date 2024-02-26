package com.customer.app.customerapp.service;

import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.BaseResponse;
import com.customer.app.customerapp.dto.resp.CustomerDetailsResponse;
import com.customer.app.customerapp.dto.resp.SaveCustomerResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface CustomerService {
    SaveCustomerResponse saveCustomerDetails(SaveCustomerDetailsReqDTO reqDTO, HttpServletRequest request);

    CustomerDetailsResponse getCustomerDetails(CustomerDetailsReqDTO reqDTO, HttpServletRequest request);
}
