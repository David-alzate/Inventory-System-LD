package co.inventory.system.ld.application.primaryports.mapper.sales;

import co.inventory.system.ld.application.primaryports.dto.sales.SaleProductDTO;
import co.inventory.system.ld.domain.sales.SaleProductDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {SaleDTOMapper.class})
public interface SaleProductDTOMapper {

    SaleProductDTOMapper INSTANCE = Mappers.getMapper(SaleProductDTOMapper.class);

    SaleProductDomain toDomain(SaleProductDTO customerDTO);

    SaleProductDTO toDTO(SaleProductDomain customerDomain);

    List<SaleProductDTO> toDTOCollection(List<SaleProductDomain> customerDomainList);
}
