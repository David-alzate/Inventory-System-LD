package co.inventory.system.ld.application.primaryports.mapper.customers;

import co.inventory.system.ld.application.primaryports.dto.customers.CustomerDTO;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CustomerDTOMapper {
	
    CustomerDTOMapper INSTANCE= Mappers.getMapper(CustomerDTOMapper.class);

    CustomerDomain toDomain(CustomerDTO customerDTO);

    CustomerDTO toDTO(CustomerDomain customerDomain);

    List<CustomerDTO> toDTOCollection(List<CustomerDomain> customerDomainList);
}
