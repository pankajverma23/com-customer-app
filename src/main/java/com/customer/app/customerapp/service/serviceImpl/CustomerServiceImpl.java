package com.customer.app.customerapp.service.serviceImpl;

import com.customer.app.customerapp.Exception.CustomerAppException;
import com.customer.app.customerapp.constant.Constant;
import com.customer.app.customerapp.dao.CustomerDetailsDao;
import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerData;
import com.customer.app.customerapp.dto.resp.CustomerDetailsResponse;
import com.customer.app.customerapp.dto.resp.SaveCustomerResponse;
import com.customer.app.customerapp.service.CustomerService;
import com.customer.app.customerapp.util.ValidationUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDetailsDao customerDetailsDao;
    @Override
    public SaveCustomerResponse saveCustomerDetails(SaveCustomerDetailsReqDTO reqDTO, HttpServletRequest request) {
        SaveCustomerResponse response = new SaveCustomerResponse();
        try{
            //Validating Request and Session
            ValidationUtil.validate(reqDTO,request);
            String name = customerDetailsDao.saveCustomerDetails(reqDTO);
            if (name != null) {
                response.setStatusCode(Constant.SUCCESS_CODE);
                response.setStatusMessage(Constant.CUSTOMER_SAVED);
                response.setData(CustomerData.builder().firstNme(name).build());
            }else {
                response.setStatusCode(Constant.FAILURE_CODE);
                response.setStatusMessage(Constant.FAILURE_MESSAGE);
            }

        }catch (CustomerAppException e){
            response.setStatusCode(e.getCode());
            response.setStatusMessage(e.getMessage());
        }

        return response;
    }

    @Override
    public CustomerDetailsResponse getCustomerDetails(CustomerDetailsReqDTO reqDTO, HttpServletRequest request) {
        CustomerDetailsResponse response = new CustomerDetailsResponse();
            try {
                //Validating Request and Session
                ValidationUtil.validateGetCustomerRequest(reqDTO, request);
                CustomerData customerData = customerDetailsDao.getCustomerDetails(reqDTO);
                if (customerData != null) {
                    response.setStatusCode(Constant.SUCCESS_CODE);
                    response.setStatusMessage(Constant.SUCCESS_MESSAGE);
                    response.setData(customerData);
                }else{
                    response.setStatusCode(Constant.FAILURE_CODE);
                    response.setStatusMessage(Constant.CUSTOMER_NOT_FOUND);
                }
            } catch (CustomerAppException e) {
                response.setStatusCode(e.getCode());
                response.setStatusMessage(e.getMessage());
            }
        return response;
    }
}
