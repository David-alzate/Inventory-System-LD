package co.inventory.system.ld.application.primaryports.interactor.suppliers.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.interactor.suppliers.DeleteSupplierInteractor;
import co.inventory.system.ld.application.usecase.suppliers.DeleteSupplier;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteSupplierInteractorImpl implements DeleteSupplierInteractor {

	private final DeleteSupplier deleteSupplier;

	public DeleteSupplierInteractorImpl(DeleteSupplier deleteSupplier) {
		this.deleteSupplier = deleteSupplier;
	}

	@Override
	public void execute(UUID data) {
		deleteSupplier.execute(data);

	}

}
