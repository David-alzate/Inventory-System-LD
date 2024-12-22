package co.inventory.system.ld.application.secondaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.domain.products.ProductDomain;

@Mapper
public interface ProductEntityMapper {

	ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

	ProductEntity toEntity(ProductDomain customerDomain);

	ProductDomain toDomain(ProductEntity customerEntity);

	List<ProductEntity> toEntityCollection(List<ProductDomain> customerDomainList);

	List<ProductDomain> toDomainCollection(List<ProductEntity> customerEntityList);

}
