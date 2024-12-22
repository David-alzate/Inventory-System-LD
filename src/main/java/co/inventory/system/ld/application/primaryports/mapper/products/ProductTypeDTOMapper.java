package co.inventory.system.ld.application.primaryports.mapper.products;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Mapper
public interface ProductTypeDTOMapper {

	ProductTypeDTOMapper INSTANCE = Mappers.getMapper(ProductTypeDTOMapper.class);

	ProductTypeDomain toDomain(ProductTypeDTO customerDTO);

	ProductTypeDTO toDTO(ProductTypeDomain customerDomain);

	List<ProductTypeDTO> toDTOCollection(List<ProductTypeDomain> customerDomainList);

}
