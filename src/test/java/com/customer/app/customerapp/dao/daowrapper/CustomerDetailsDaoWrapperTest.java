package com.customer.app.customerapp.dao.daowrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerData;
import com.customer.app.customerapp.entity.CustomerDetailsEntity;
import com.customer.app.customerapp.entity.id.CustomerDetailsID;
import com.customer.app.customerapp.repository.CustomerDetailsRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerDetailsDaoWrapperTest {

    @InjectMocks
    private CustomerDetailsDaoWrapper customerDetailsDaoWrapper;

    @Mock
    private CustomerDetailsRepo customerDetailsRepo;

    @Test
    void testSaveCustomerDetails() {
        // Arrange
        CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();
        customerDetailsEntity.setAddress("42 Main St");
        customerDetailsEntity.setDateOfBirth("23/02/1996");
        customerDetailsEntity.setEmail("jane.doe@example.org");
        customerDetailsEntity.setFirstNme("First Nme");
        customerDetailsEntity.setLastName("Doe");
        customerDetailsEntity.setPhone("6625550144");
        when(customerDetailsRepo.save(Mockito.any())).thenReturn(customerDetailsEntity);

        // Act
        String actualSaveCustomerDetailsResult = customerDetailsDaoWrapper
                .saveCustomerDetails(new SaveCustomerDetailsReqDTO("First Nme", "Doe", "jane.doe@example.org", "6625550144",
                        "42 Main St", "2020-03-01"));

        // Assert
        verify(customerDetailsRepo).save(Mockito.any());
        assertEquals("First Nme", actualSaveCustomerDetailsResult);
    }

    @Test
    void testGetCustomerDetails() {
        // Arrange
        CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();
        customerDetailsEntity.setAddress("42 Main St");
        customerDetailsEntity.setDateOfBirth("23/02/1996");
        customerDetailsEntity.setEmail("jane.doe@example.org");
        customerDetailsEntity.setFirstNme("First Nme");
        customerDetailsEntity.setLastName("Doe");
        customerDetailsEntity.setPhone("6625550144");
        Optional<CustomerDetailsEntity> ofResult = Optional.of(customerDetailsEntity);
        when(customerDetailsRepo.findById(Mockito.any())).thenReturn(ofResult);

        // Act
        CustomerData actualCustomerDetails = customerDetailsDaoWrapper
                .getCustomerDetails(new CustomerDetailsReqDTO("jane.doe@example.org", "6625550144", "23/02/1996"));

        // Assert
        verify(customerDetailsRepo).findById(Mockito.any());
        assertEquals("23/02/1996", actualCustomerDetails.getDateOfBirth());
        assertEquals("42 Main St", actualCustomerDetails.getAddress());
        assertEquals("6625550144", actualCustomerDetails.getPhone());
        assertEquals("Doe", actualCustomerDetails.getLastName());
        assertEquals("First Nme", actualCustomerDetails.getFirstNme());
        assertEquals("jane.doe@example.org", actualCustomerDetails.getEmail());
    }

    @Test
    void testGetCustomerDetails2() {
        // Arrange
        Optional<CustomerDetailsEntity> emptyResult = Optional.empty();
        when(customerDetailsRepo.findById(Mockito.any())).thenReturn(emptyResult);

        // Act
        CustomerData actualCustomerDetails = customerDetailsDaoWrapper
                .getCustomerDetails(new CustomerDetailsReqDTO("jane.doe@example.org", "6625550144", "2020-03-01"));

        // Assert
        verify(customerDetailsRepo).findById(Mockito.any());
        assertNull(actualCustomerDetails);
    }
}
