package co.inventory.system.ld.application.secondaryports.mapper.sales;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleProductEntity;
import co.inventory.system.ld.domain.sales.SaleProductDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SaleProductEntityMapper {

    SaleProductEntityMapper INSTANCE = Mappers.getMapper(SaleProductEntityMapper.class);

    @Mapping(target = "sale", ignore = true)
    SaleProductEntity toEntity(SaleProductDomain domain);

    @Mapping(target = "sale", ignore = true)
    SaleProductDomain toDomain(SaleProductEntity entity);

    List<SaleProductEntity> toEntityCollection(List<SaleProductDomain> domainCollection);

    List<SaleProductDomain> toDomainCollection(List<SaleProductEntity> entityCollection);
}
