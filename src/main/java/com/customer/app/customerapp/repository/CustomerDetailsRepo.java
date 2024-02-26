package com.customer.app.customerapp.repository;

import com.customer.app.customerapp.entity.CustomerDetailsEntity;
import com.customer.app.customerapp.entity.id.CustomerDetailsID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepo  extends JpaRepository<CustomerDetailsEntity, CustomerDetailsID> {

}
