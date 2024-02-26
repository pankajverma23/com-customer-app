package com.customer.app.customerapp.dto.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class CustomerData {
    private String firstNme;
    private String lastName;
    private String email;
    @Id
    private String phone;
    private String address;
    private String dateOfBirth;
}
