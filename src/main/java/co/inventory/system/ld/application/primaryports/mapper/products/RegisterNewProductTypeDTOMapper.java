package co.inventory.system.ld.application.primaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductTypeDTO;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Mapper
public interface RegisterNewProductTypeDTOMapper {

	RegisterNewProductTypeDTOMapper INSTANCE = Mappers.getMapper(RegisterNewProductTypeDTOMapper.class);

	@Mapping(target = "id", ignore = true)
	ProductTypeDomain toDomain(RegisterNewProductTypeDTO customerDTO);

	RegisterNewProductTypeDTO toDTO(ProductTypeDomain customerDomain);

	List<RegisterNewProductTypeDTO> toDTOCollection(List<ProductTypeDomain> customerDomainList);

}