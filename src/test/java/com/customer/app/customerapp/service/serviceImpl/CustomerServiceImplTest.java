package com.customer.app.customerapp.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.customer.app.customerapp.dao.CustomerDetailsDao;
import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerDetailsResponse;
import com.customer.app.customerapp.dto.resp.SaveCustomerResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @MockBean
    private CustomerDetailsDao customerDetailsDao;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    
    @Test
    void testSaveCustomerDetails() {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO("First Nme", "Doe", "jane.doe@example.org",
                "6625550144", "42 Main St", "23/02/1996");

        // Act
        SaveCustomerResponse actualSaveCustomerDetailsResult = customerServiceImpl.saveCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Not Authorized please pass header [X-Auth-Header]. (For testing apis please pass your phone as header"
                + " value.)", actualSaveCustomerDetailsResult.getStatusMessage());
        assertEquals(403, actualSaveCustomerDetailsResult.getStatusCode().intValue());
    }

    @Test
    void testSaveCustomerDetails2() {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO("", "Doe", "jane.doe@example.org", "6625550144",
                "42 Main St", "23/02/1996");

        // Act
        SaveCustomerResponse actualSaveCustomerDetailsResult = customerServiceImpl.saveCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Required Fields are null provide [firstName,phone,dateOfBirth,email]",
                actualSaveCustomerDetailsResult.getStatusMessage());
        assertEquals(400, actualSaveCustomerDetailsResult.getStatusCode().intValue());
    }

    @Test
    void testSaveCustomerDetails3() {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO("First Nme", "Doe", "jane.doe@example.org",
                "+44 1865 4960636", "42 Main St", "23/02/1996");

        // Act
        SaveCustomerResponse actualSaveCustomerDetailsResult = customerServiceImpl.saveCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Phone number should be 10 digits.", actualSaveCustomerDetailsResult.getStatusMessage());
        assertEquals(400, actualSaveCustomerDetailsResult.getStatusCode().intValue());
    }

    @Test
    void testSaveCustomerDetails4() {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = new SaveCustomerDetailsReqDTO();

        // Act
        SaveCustomerResponse actualSaveCustomerDetailsResult = customerServiceImpl.saveCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Required Fields are null provide [firstName,phone,dateOfBirth,email]",
                actualSaveCustomerDetailsResult.getStatusMessage());
        assertEquals(400, actualSaveCustomerDetailsResult.getStatusCode().intValue());
    }

    @Test
    void testSaveCustomerDetails5() {
        // Arrange and Act
        SaveCustomerResponse actualSaveCustomerDetailsResult = customerServiceImpl.saveCustomerDetails(null,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Invalid Request", actualSaveCustomerDetailsResult.getStatusMessage());
        assertEquals(400, actualSaveCustomerDetailsResult.getStatusCode().intValue());
    }

    @Test
    void testSaveCustomerDetails6() {
        // Arrange
        SaveCustomerDetailsReqDTO reqDTO = mock(SaveCustomerDetailsReqDTO.class);
        when(reqDTO.getDateOfBirth()).thenReturn("23/02/1996");
        when(reqDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(reqDTO.getFirstNme()).thenReturn("First Nme");
        when(reqDTO.getPhone()).thenReturn("6625550144");

        // Act
        SaveCustomerResponse actualSaveCustomerDetailsResult = customerServiceImpl.saveCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        verify(reqDTO).getDateOfBirth();
        verify(reqDTO).getEmail();
        verify(reqDTO).getFirstNme();
        verify(reqDTO, atLeast(1)).getPhone();
        assertEquals("Not Authorized please pass header [X-Auth-Header]. (For testing apis please pass your phone as header"
                + " value.)", actualSaveCustomerDetailsResult.getStatusMessage());
        assertEquals(403, actualSaveCustomerDetailsResult.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails() {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO("jane.doe@example.org", "6625550144", "23/02/1996");

        // Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Not Authorized please pass header [X-Auth-Header]. (For testing apis please pass your phone as header"
                + " value.)", actualCustomerDetails.getStatusMessage());
        assertEquals(403, actualCustomerDetails.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails2() {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO("john.smith@example.org", "6625550144", "23/02/1996");

        // Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Not Authorized please pass header [X-Auth-Header]. (For testing apis please pass your phone as header"
                + " value.)", actualCustomerDetails.getStatusMessage());
        assertEquals(403, actualCustomerDetails.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails3() {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO("", "6625550144", "23/02/1996");

        // Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Required Fields are null provide [phone,dateOfBirth,email]",
                actualCustomerDetails.getStatusMessage());
        assertEquals(400, actualCustomerDetails.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails4() {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO("jane.doe@example.org", "+44 1865 4960636", "23/02/1996");

        // Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Phone number should be 10 digits.", actualCustomerDetails.getStatusMessage());
        assertEquals(400, actualCustomerDetails.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails5() {
        // Arrange
        CustomerDetailsReqDTO reqDTO = new CustomerDetailsReqDTO();

        // Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Required Fields are null provide [phone,dateOfBirth,email]",
                actualCustomerDetails.getStatusMessage());
        assertEquals(400, actualCustomerDetails.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails6() {
        // Arrange and Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(null,
                new MockHttpServletRequest());

        // Assert
        assertEquals("Invalid Request", actualCustomerDetails.getStatusMessage());
        assertEquals(400, actualCustomerDetails.getStatusCode().intValue());
    }

   
    @Test
    void testGetCustomerDetails7() {
        // Arrange
        CustomerDetailsReqDTO reqDTO = mock(CustomerDetailsReqDTO.class);
        when(reqDTO.getDateOfBirth()).thenReturn("23/02/1996");
        when(reqDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(reqDTO.getPhone()).thenReturn("6625550144");

        // Act
        CustomerDetailsResponse actualCustomerDetails = customerServiceImpl.getCustomerDetails(reqDTO,
                new MockHttpServletRequest());

        // Assert
        verify(reqDTO).getDateOfBirth();
        verify(reqDTO).getEmail();
        verify(reqDTO, atLeast(1)).getPhone();
        assertEquals("Not Authorized please pass header [X-Auth-Header]. (For testing apis please pass your phone as header"
                + " value.)", actualCustomerDetails.getStatusMessage());
        assertEquals(403, actualCustomerDetails.getStatusCode().intValue());
    }
}
