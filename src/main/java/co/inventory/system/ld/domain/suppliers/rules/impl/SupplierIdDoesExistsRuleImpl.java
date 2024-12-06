package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.application.secondaryports.repository.suppliers.SupplierRepository;
import co.inventory.system.ld.domain.suppliers.exceptions.SupplierIdDoesNotExistException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierIdDoesExistsRule;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class SupplierIdDoesExistsRuleImpl implements SupplierIdDoesExistsRule {

    private SupplierRepository supplierRepository;

    public SupplierIdDoesExistsRuleImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void validate(final UUID data) {
        if (!supplierRepository.existsById(data)) {
            throw SupplierIdDoesNotExistException.create();
        }
    }
}
