package co.inventory.system.ld.application.primaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.domain.products.ProductDomain;

@Mapper
public interface ProductDTOMapper {

	ProductDTOMapper INSTANCE = Mappers.getMapper(ProductDTOMapper.class);

	ProductDomain toDomain(ProductDTO customerDTO);

	ProductDTO toDTO(ProductDomain customerDomain);

	List<ProductDTO> toDTOCollection(List<ProductDomain> customerDomainList);

}
