package co.inventory.system.ld.application.primaryports.interactor.suppliers.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.application.primaryports.interactor.suppliers.UpdateSupplierInteractor;
import co.inventory.system.ld.application.primaryports.mapper.suppliers.SupplierDTOMapper;
import co.inventory.system.ld.application.usecase.suppliers.UpdateSupplier;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UpdateSupplierInteractorImpl implements UpdateSupplierInteractor {

	private UpdateSupplier updateSupplier;

	public UpdateSupplierInteractorImpl(UpdateSupplier updateSupplier) {
		this.updateSupplier = updateSupplier;
	}

	@Override
	public void execute(SupplierDTO data) {
		try {
			var supplierDomain = SupplierDTOMapper.INSTANCE.toDomain(data);
			updateSupplier.execute(supplierDomain);
		} catch (InventorySystemException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = "Se ha presentado un problema modificando el proveedor";
			var technicalMessage = "Se ha presentado un problema INESPERADO modificando el proveedor";

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
