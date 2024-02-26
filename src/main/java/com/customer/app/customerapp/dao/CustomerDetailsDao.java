package com.customer.app.customerapp.dao;


import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerData;

public interface CustomerDetailsDao {

    String saveCustomerDetails(SaveCustomerDetailsReqDTO reqDTO);

    CustomerData getCustomerDetails(CustomerDetailsReqDTO reqDTO);
}
