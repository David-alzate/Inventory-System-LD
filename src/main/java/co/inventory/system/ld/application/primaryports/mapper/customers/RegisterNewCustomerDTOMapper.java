package co.inventory.system.ld.application.primaryports.mapper.customers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.customers.RegisterNewCustomerDTO;
import co.inventory.system.ld.domain.customers.CustomerDomain;

@Mapper
public interface RegisterNewCustomerDTOMapper {

    RegisterNewCustomerDTOMapper INSTANCE= Mappers.getMapper(RegisterNewCustomerDTOMapper.class);
    
    @Mapping(target = "id", ignore = true)
    CustomerDomain toDomain(RegisterNewCustomerDTO supplierDTO);

    RegisterNewCustomerDTO toDTO(CustomerDomain customerDomain);

    List<RegisterNewCustomerDTO> toDTO(List<CustomerDomain> customerDomainList);

}
