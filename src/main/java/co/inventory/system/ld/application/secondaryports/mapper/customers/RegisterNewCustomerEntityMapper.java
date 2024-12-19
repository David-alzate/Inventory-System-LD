package co.inventory.system.ld.application.secondaryports.mapper.customers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.domain.customers.CustomerDomain;

@Mapper
public interface RegisterNewCustomerEntityMapper {
	RegisterNewCustomerEntityMapper INSTANCE = Mappers.getMapper(RegisterNewCustomerEntityMapper.class);

	CustomerEntity toEntity(CustomerDomain domain);

	CustomerDomain toDomain(CustomerEntity entity);

	List<CustomerEntity> toEntityCollection(List<CustomerDomain> domainCollection);

	List<CustomerDomain> toDomainCollection(List<CustomerEntity> entityCollection);
}
