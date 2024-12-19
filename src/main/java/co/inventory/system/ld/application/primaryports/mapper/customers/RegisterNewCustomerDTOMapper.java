package co.inventory.system.ld.application.primaryports.mapper.customers;

import co.inventory.system.ld.application.primaryports.dto.customers.RegisterNewCustomerDTO;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterNewCustomerDTOMapper {

    RegisterNewCustomerDTOMapper INSTANCE= Mappers.getMapper(RegisterNewCustomerDTOMapper.class);

    CustomerDomain toDomain(RegisterNewCustomerDTO supplierDTO);

    RegisterNewCustomerDTO toDTO(CustomerDomain customerDomain);

    List<RegisterNewCustomerDTO> toDTO(List<CustomerDomain> customerDomainList);

}
