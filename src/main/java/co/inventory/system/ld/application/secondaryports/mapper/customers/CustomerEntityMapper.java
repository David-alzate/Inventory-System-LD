package co.inventory.system.ld.application.secondaryports.mapper.customers;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerEntityMapper {
    CustomerEntityMapper INSTANCE = Mappers.getMapper(CustomerEntityMapper.class);

    CustomerEntity toEntity(CustomerDomain customerDomain);

    CustomerDomain toDomain(CustomerEntity customerEntity);

    List<CustomerEntity> toEntityCollection(List<CustomerDomain> customerDomainList);

    List<CustomerDomain> toDomainCollection(List<CustomerEntity> customerEntityList);

}
