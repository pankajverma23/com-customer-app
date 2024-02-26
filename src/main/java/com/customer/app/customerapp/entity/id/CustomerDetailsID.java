package com.customer.app.customerapp.entity.id;


import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDetailsID implements Serializable {

    private String email;

    private String phone;

    private String dateOfBirth;
}
