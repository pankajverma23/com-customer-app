package com.customer.app.customerapp.util;

import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerData;
import com.customer.app.customerapp.entity.CustomerDetailsEntity;
import com.customer.app.customerapp.entity.id.CustomerDetailsID;
import org.springframework.beans.BeanUtils;

public class ModelMappingUtil {
    public static CustomerDetailsEntity generateEntity(SaveCustomerDetailsReqDTO reqDTO) {
        CustomerDetailsEntity entity = new CustomerDetailsEntity();
        BeanUtils.copyProperties(reqDTO, entity);
        return entity;
    }

    public static CustomerDetailsID generateId(CustomerDetailsReqDTO reqDTO) {
        CustomerDetailsID id = new CustomerDetailsID();
        id.setPhone(reqDTO.getPhone());
        id.setEmail(reqDTO.getEmail());
        id.setDateOfBirth(reqDTO.getDateOfBirth());
        return id;
    }

    public static CustomerData generateDataDTO(CustomerDetailsEntity customerDetailsEntity) {
        CustomerData customerData = new CustomerData();
        BeanUtils.copyProperties(customerDetailsEntity, customerData);
        return customerData;
    }
}
