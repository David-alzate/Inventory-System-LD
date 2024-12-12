package co.inventory.system.ld.application.primaryports.mapper.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.RegisterNewSupplierDTO;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterNewSupplierDTOMapper {
    RegisterNewSupplierDTOMapper INSTANCE= Mappers.getMapper(RegisterNewSupplierDTOMapper.class);

    SupplierDomain toDomain(RegisterNewSupplierDTO supplierDTO);

    RegisterNewSupplierDTO toDTO(SupplierDomain supplierDomain);

    List<RegisterNewSupplierDTO> toDTO(List<SupplierDomain> supplierDomainList);
}

