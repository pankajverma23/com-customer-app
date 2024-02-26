package com.customer.app.customerapp.controller;

import static org.mockito.Mockito.when;

import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerDetailsResponse;
import com.customer.app.customerapp.dto.resp.SaveCustomerResponse;
import com.customer.app.customerapp.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class CustomerAppControllerTest {

    @InjectMocks
    private CustomerAppController customerAppController;

    @Mock
    private CustomerService customerService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerAppController).build();
    }

    @Test
    void testGetCustomer() throws Exception {
        // Arrange
        when(customerService.getCustomerDetails(Mockito.any(), Mockito.any()))
                .thenReturn(new CustomerDetailsResponse());

        CustomerDetailsReqDTO customerDetailsReqDTO = new CustomerDetailsReqDTO();
        customerDetailsReqDTO.setDateOfBirth("23/02/1996");
        customerDetailsReqDTO.setEmail("jane.doe@example.org");
        customerDetailsReqDTO.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(customerDetailsReqDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get-customer-details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    void testSaveCustomer() throws Exception {
        // Arrange
        when(customerService.saveCustomerDetails(Mockito.any(), Mockito.any()))
                .thenReturn(new SaveCustomerResponse());

        SaveCustomerDetailsReqDTO saveCustomerDetailsReqDTO = new SaveCustomerDetailsReqDTO();
        saveCustomerDetailsReqDTO.setAddress("42 Main St");
        saveCustomerDetailsReqDTO.setDateOfBirth("23/02/1996");
        saveCustomerDetailsReqDTO.setEmail("jane.doe@example.org");
        saveCustomerDetailsReqDTO.setFirstNme("First Nme");
        saveCustomerDetailsReqDTO.setLastName("Doe");
        saveCustomerDetailsReqDTO.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(saveCustomerDetailsReqDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/save-customer-details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }
}
