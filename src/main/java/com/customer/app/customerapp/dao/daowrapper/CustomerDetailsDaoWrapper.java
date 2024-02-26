package com.customer.app.customerapp.dao.daowrapper;

import com.customer.app.customerapp.dao.CustomerDetailsDao;
import com.customer.app.customerapp.dto.req.CustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.req.SaveCustomerDetailsReqDTO;
import com.customer.app.customerapp.dto.resp.CustomerData;
import com.customer.app.customerapp.entity.CustomerDetailsEntity;
import com.customer.app.customerapp.entity.id.CustomerDetailsID;
import com.customer.app.customerapp.repository.CustomerDetailsRepo;
import com.customer.app.customerapp.util.ModelMappingUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerDetailsDaoWrapper implements CustomerDetailsDao {

    private final CustomerDetailsRepo repo;

    @Override
    public String saveCustomerDetails(SaveCustomerDetailsReqDTO reqDTO) {
        CustomerDetailsEntity entity = ModelMappingUtil.generateEntity(reqDTO);
        CustomerDetailsEntity  savedEntity = repo.save(entity);
        if (savedEntity != null)
            return savedEntity.getFirstNme();
        else
            return null;
    }

    @Override
    public CustomerData getCustomerDetails(CustomerDetailsReqDTO reqDTO) {

        CustomerDetailsID id = ModelMappingUtil.generateId(reqDTO);
        Optional<CustomerDetailsEntity> entity = repo.findById(id);

        if (entity.isPresent())
            return ModelMappingUtil.generateDataDTO(entity.get());
        return null;
    }


}
