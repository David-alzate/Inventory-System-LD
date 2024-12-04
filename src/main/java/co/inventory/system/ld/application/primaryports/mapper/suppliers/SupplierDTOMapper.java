package co.inventory.system.ld.application.primaryports.mapper.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SupplierDTOMapper {

    SupplierDTOMapper INSTANCE= Mappers.getMapper(SupplierDTOMapper.class);

    SupplierDomain toDomain(SupplierDTO supplierDTO);

    SupplierDTO toDTO(SupplierDomain supplierDomain);

    List<SupplierDTO> toDTO(List<SupplierDomain> supplierDomainList);
}
