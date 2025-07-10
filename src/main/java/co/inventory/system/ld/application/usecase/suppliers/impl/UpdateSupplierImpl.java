package co.inventory.system.ld.application.usecase.suppliers.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import co.inventory.system.ld.application.secondaryports.mapper.commons.StatusEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.suppliers.SupplierRepository;
import co.inventory.system.ld.application.usecase.suppliers.UpdateSupplier;
import co.inventory.system.ld.application.usecase.suppliers.rulesvalidator.UpdateSupplierRulesValidator;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

@Service
public class UpdateSupplierImpl implements UpdateSupplier {

	private SupplierRepository supplierRepository;
	private UpdateSupplierRulesValidator updateSupplierRulesValidator;

	public UpdateSupplierImpl(SupplierRepository supplierRepository,
			UpdateSupplierRulesValidator updateSupplierRulesValidator) {
		this.supplierRepository = supplierRepository;
		this.updateSupplierRulesValidator = updateSupplierRulesValidator;
	}

	@Override
	public void execute(SupplierDomain domain) {

		updateSupplierRulesValidator.validate(domain);

		final var supplierEntity = SupplierEntity.create().setId(domain.getId()).setName(domain.getName())
				.setStatus(StatusEntityMapper.INSTANCE.toEntity(domain.getStatus()));

		supplierRepository.save(supplierEntity);

	}

}
