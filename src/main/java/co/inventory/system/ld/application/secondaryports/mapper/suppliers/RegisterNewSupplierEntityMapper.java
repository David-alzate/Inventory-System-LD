package co.inventory.system.ld.application.secondaryports.mapper.suppliers;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface RegisterNewSupplierEntityMapper {
    RegisterNewSupplierEntityMapper INSTANCE = Mappers.getMapper(RegisterNewSupplierEntityMapper.class);

    SupplierEntity toEntity(SupplierDomain domain);

    SupplierDomain toDomain(SupplierEntity entity);

    List<SupplierEntity> toEntityCollection(List<SupplierDomain> domainCollection);

    List<SupplierDomain> toDomainCollection(List<SupplierEntity> entityCollection);
}
