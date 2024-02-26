package com.customer.app.customerapp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerData;
import com.customer.app.customerapp.entity.CustomerDetailsEntity;
import com.customer.app.customerapp.entity.id.CustomerDetailsID;
import org.junit.jupiter.api.Test;

class ModelMappingUtilTest {


    @Test
    void testGenerateId() {
        // Arrange and Act
        CustomerDetailsID actualGenerateIdResult = ModelMappingUtil
                .generateId(new CustomerDetailsReqDTO("jane.doe@example.org", "6625550144", "23/02/1996"));

        // Assert
        assertEquals("23/02/1996", actualGenerateIdResult.getDateOfBirth());
        assertEquals("6625550144", actualGenerateIdResult.getPhone());
        assertEquals("jane.doe@example.org", actualGenerateIdResult.getEmail());
    }


    @Test
    void testGenerateDataDTO() {
        // Arrange
        CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();
        customerDetailsEntity.setAddress("42 Main St");
        customerDetailsEntity.setDateOfBirth("23/02/1996");
        customerDetailsEntity.setEmail("jane.doe@example.org");
        customerDetailsEntity.setFirstNme("First Nme");
        customerDetailsEntity.setLastName("Doe");
        customerDetailsEntity.setPhone("6625550144");

        // Act
        CustomerData actualGenerateDataDTOResult = ModelMappingUtil.generateDataDTO(customerDetailsEntity);

        // Assert
        assertEquals("23/02/1996", actualGenerateDataDTOResult.getDateOfBirth());
        assertEquals("42 Main St", actualGenerateDataDTOResult.getAddress());
        assertEquals("6625550144", actualGenerateDataDTOResult.getPhone());
        assertEquals("Doe", actualGenerateDataDTOResult.getLastName());
        assertEquals("First Nme", actualGenerateDataDTOResult.getFirstNme());
        assertEquals("jane.doe@example.org", actualGenerateDataDTOResult.getEmail());
    }
}
