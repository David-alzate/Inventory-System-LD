package co.inventory.system.ld.application.secondaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.domain.products.ProductDomain;

@Mapper
public interface RegisterNewProductEntityMapper {

	RegisterNewProductEntityMapper INSTANCE = Mappers.getMapper(RegisterNewProductEntityMapper.class);

	ProductEntity toEntity(ProductDomain domain);

	ProductDomain toDomain(ProductEntity entity);

	List<ProductEntity> toEntityCollection(List<ProductDomain> domainCollection);

	List<ProductDomain> toDomainCollection(List<ProductEntity> entityCollection);

}
