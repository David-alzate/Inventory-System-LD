package co.inventory.system.ld.application.usecase.suppliers.impl;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import co.inventory.system.ld.application.secondaryports.mapper.commons.StatusEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.suppliers.SupplierRepository;
import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplier;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

public class RegisterNewSupplierImpl  implements RegisterNewSupplier {

    private final SupplierRepository supplierRepository;

    public RegisterNewSupplierImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void execute(SupplierDomain domain) {
        final var supplierEntity= SupplierEntity.create().setId(domain.getId())
                .setName(domain.getName())
                .setStatus(StatusEntityMapper.INSTANCE.toEntity(domain.getStatus()));

        supplierRepository.save(supplierEntity);
    }
}
