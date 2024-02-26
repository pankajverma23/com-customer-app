package com.customer.app.customerapp.entity;

import com.customer.app.customerapp.entity.id.CustomerDetailsID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@IdClass(CustomerDetailsID.class)
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetailsEntity {

    private String firstNme;
    private String lastName;
    @Id
    private String email;
    @Id
    private String phone;
    private String address;
    @Id
    private String dateOfBirth;
}
