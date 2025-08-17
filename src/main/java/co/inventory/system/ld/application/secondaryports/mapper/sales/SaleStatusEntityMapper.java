package co.inventory.system.ld.application.secondaryports.mapper.sales;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleStatusEntity;
import co.inventory.system.ld.domain.sales.SaleStatusDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SaleStatusEntityMapper {
    SaleStatusEntityMapper INSTANCE = Mappers.getMapper(SaleStatusEntityMapper.class);

    SaleStatusEntity toEntity(SaleStatusDomain domain);
    SaleStatusDomain toDomain(SaleStatusEntity entity);

    List<SaleStatusEntity> toEntityCollection(List<SaleStatusDomain> domainCollection);
    List<SaleStatusDomain> toDomainCollection(List<SaleStatusEntity> entityCollection);
}
