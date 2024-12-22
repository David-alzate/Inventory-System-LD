package co.inventory.system.ld.application.primaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductDTO;
import co.inventory.system.ld.domain.products.ProductDomain;

@Mapper
public interface RegisterNewProductDTOMapper {

	RegisterNewProductDTOMapper INSTANCE = Mappers.getMapper(RegisterNewProductDTOMapper.class);

	@Mapping(target = "id", ignore = true)
	ProductDomain toDomain(RegisterNewProductDTO supplierDTO);

	RegisterNewProductDTO toDTO(ProductDomain customerDomain);

	List<RegisterNewProductDTO> toDTO(List<ProductDomain> customerDomainList);

}
