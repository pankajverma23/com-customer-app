package com.customer.app.customerapp.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.customer.app.customerapp.Exception.CustomerAppException;
import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class ValidationUtilTest {
   
    @Test
    void testValidate() throws CustomerAppException {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO("First Nme", "Doe", "jane.doe@example.org",
                "6625550144", "42 Main St", "23/02/1996");

        // Act and Assert
        assertThrows(CustomerAppException.class, () -> ValidationUtil.validate(reqDTO, new MockHttpServletRequest()));
    }

    
    @Test
    void testValidate2() throws CustomerAppException {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO(null, "Doe", "jane.doe@example.org", "6625550144",
                "42 Main St", "23/02/1996");

        // Act and Assert
        assertThrows(CustomerAppException.class, () -> ValidationUtil.validate(reqDTO, new MockHttpServletRequest()));
    }

   
    @Test
    void testValidate3() throws CustomerAppException {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO("First Nme", "Doe", "jane.doe@example.org",
                "+44 1865 4960636", "42 Main St", "23/02/1996");

        // Act and Assert
        assertThrows(CustomerAppException.class, () -> ValidationUtil.validate(reqDTO, new MockHttpServletRequest()));
    }

   
    @Test
    void testValidate4() throws CustomerAppException {
        // Arrange, Act and Assert
        assertThrows(CustomerAppException.class, () -> ValidationUtil.validate(null, new MockHttpServletRequest()));
    }

    
    @Test
    void testValidateGetCustomerRequest() throws CustomerAppException {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO("jane.doe@example.org", "6625550144", "23/02/1996");

        // Act and Assert
        assertThrows(CustomerAppException.class,
                () -> ValidationUtil.validateGetCustomerRequest(reqDTO, new MockHttpServletRequest()));
    }

    
    @Test
    void testValidateGetCustomerRequest2() throws CustomerAppException {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO(null, "6625550144", "23/02/1996");

        // Act and Assert
        assertThrows(CustomerAppException.class,
                () -> ValidationUtil.validateGetCustomerRequest(reqDTO, new MockHttpServletRequest()));
    }

    
    @Test
    void testValidateGetCustomerRequest3() throws CustomerAppException {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO("jane.doe@example.org", "+44 1865 4960636", "23/02/1996");

        // Act and Assert
        assertThrows(CustomerAppException.class,
                () -> ValidationUtil.validateGetCustomerRequest(reqDTO, new MockHttpServletRequest()));
    }

    
    @Test
    void testValidateGetCustomerRequest4() throws CustomerAppException {
        // Arrange, Act and Assert
        assertThrows(CustomerAppException.class,
                () -> ValidationUtil.validateGetCustomerRequest(null, new MockHttpServletRequest()));
    }
}
