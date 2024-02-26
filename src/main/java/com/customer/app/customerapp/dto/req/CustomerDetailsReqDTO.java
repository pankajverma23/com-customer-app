package com.customer.app.customerapp.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsReqDTO {
    private String email;
    private String phone;
    private String dateOfBirth;
}
