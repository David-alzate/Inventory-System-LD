package co.inventory.system.ld.application.primaryports.mapper.sales;

import co.inventory.system.ld.application.primaryports.dto.sales.SaleDTO;
import co.inventory.system.ld.domain.sales.SaleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {SaleProductDTOMapper.class})
public interface SaleDTOMapper {

    SaleDTOMapper INSTANCE = Mappers.getMapper(SaleDTOMapper.class);

    SaleDomain toDomain(SaleDTO customerDTO);

    SaleDTO toDTO(SaleDomain customerDomain);

    List<SaleDTO> toDTOCollection(List<SaleDomain> customerDomainList);
}
