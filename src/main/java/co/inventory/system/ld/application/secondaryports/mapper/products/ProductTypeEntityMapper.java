package co.inventory.system.ld.application.secondaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductTypeEntity;
import co.inventory.system.ld.domain.products.ProductTypeDomain;


@Mapper
public interface ProductTypeEntityMapper {

	ProductTypeEntityMapper INSTANCE = Mappers.getMapper(ProductTypeEntityMapper.class);

	ProductTypeEntity toEntity(ProductTypeDomain domain);

	ProductTypeDomain toDomain(ProductTypeEntity entity);

	List<ProductTypeEntity> toEntityCollection(List<ProductTypeDomain> domainCollection);

	List<ProductTypeDomain> toDomainCollection(List<ProductTypeEntity> entityCollection);

}
