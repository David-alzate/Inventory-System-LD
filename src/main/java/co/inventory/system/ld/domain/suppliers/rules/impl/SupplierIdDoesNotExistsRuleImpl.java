package co.inventory.system.ld.domain.suppliers.rules.impl;

import co.inventory.system.ld.application.secondaryports.repository.suppliers.SupplierRepository;
import co.inventory.system.ld.domain.suppliers.exceptions.SupplierIdDoesNotExistException;
import co.inventory.system.ld.domain.suppliers.rules.SupplierIdDoesNotExistsRule;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class SupplierIdDoesNotExistsRuleImpl implements SupplierIdDoesNotExistsRule {

    private SupplierRepository supplierRepository;

    public SupplierIdDoesNotExistsRuleImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void validate(UUID data) {
        if (supplierRepository.existsById(data)) {
            throw SupplierIdDoesNotExistException.create();
        }
    }
}
