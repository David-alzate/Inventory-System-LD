package co.inventory.system.ld.application.secondaryports.mapper.customers;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.hibernate.usertype.CompositeUserType;
import org.mapstruct.factory.Mappers;
import java.util.List;

public interface RegisterNewCustomerEntityMapper {
    RegisterNewCustomerEntityMapper INSTANCE = Mappers.getMapper(RegisterNewCustomerEntityMapper.class);

    CustomerEntity toEntity(CustomerDomain domain);

    CustomerDomain toDomain(CompositeUserType entity);

    List<CustomerEntity> toEntityCollection(List<CustomerDomain> domainCollection);

    List<CustomerDomain> toDomainCollection(List<CustomerEntity> entityCollection);
}
