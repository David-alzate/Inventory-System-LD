package co.inventory.system.ld.application.usecase.suppliers.impl;

import co.inventory.system.ld.application.secondaryports.mapper.suppliers.SupplierEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.suppliers.SupplierRepository;
import co.inventory.system.ld.application.usecase.suppliers.GetSupplier;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSupplierImpl implements GetSupplier {

    private final SupplierRepository supplierRepository;

    public GetSupplierImpl(SupplierRepository supplierRepository) {
        super();
        this.supplierRepository= supplierRepository;
    }

    @Override
    public List<SupplierDomain> execute(SupplierDomain domain) {
        var supplierEntity= SupplierEntityMapper.INSTANCE.toEntity(domain);
        var results= supplierRepository.findByFilter(supplierEntity);
        return SupplierEntityMapper.INSTANCE.toDomainCollection(results);
    }
}
