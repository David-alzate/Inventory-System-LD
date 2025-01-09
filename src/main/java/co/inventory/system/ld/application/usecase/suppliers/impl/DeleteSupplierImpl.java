package co.inventory.system.ld.application.usecase.suppliers.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.suppliers.SupplierRepository;
import co.inventory.system.ld.application.usecase.suppliers.DeleteSupplier;

@Service
public class DeleteSupplierImpl implements DeleteSupplier {

	private final SupplierRepository supplierRepository;

	public DeleteSupplierImpl(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public void execute(UUID domain) {
		supplierRepository.deleteById(domain);

	}

}
