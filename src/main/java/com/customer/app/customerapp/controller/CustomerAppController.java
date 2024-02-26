package com.customer.app.customerapp.controller;

import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerDetailsResponse;
import com.customer.app.customerapp.dto.resp.SaveCustomerResponse;
import com.customer.app.customerapp.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerAppController {


    private final CustomerService customerService;


    @PostMapping("/save-customer-details")
    public ResponseEntity<SaveCustomerResponse> saveCustomer(@RequestBody SaveCustomerDetailsReqDTO reqDTO , HttpServletRequest request){
        SaveCustomerResponse response =  customerService.saveCustomerDetails(reqDTO, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-customer-details")
    public ResponseEntity<CustomerDetailsResponse> getCustomer(@RequestBody CustomerDetailsReqDTO reqDTO, HttpServletRequest request){
        CustomerDetailsResponse response =  customerService.getCustomerDetails(reqDTO, request);
        return ResponseEntity.ok(response);
    }

}
