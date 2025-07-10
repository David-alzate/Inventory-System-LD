package co.inventory.system.ld.application.secondaryports.mapper.sales;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleEntity;
import co.inventory.system.ld.domain.sales.SaleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = SaleProductEntityMapper.class)
public interface SaleEntityMapper {

    SaleEntityMapper INSTANCE = Mappers.getMapper(SaleEntityMapper.class);

    SaleEntity toEntity(SaleDomain domain);

    SaleDomain toDomain(SaleEntity entity);

    List<SaleEntity> toEntityCollection(List<SaleDomain> domainCollection);

    List<SaleDomain> toDomainCollection(List<SaleEntity> entityCollection);
}
