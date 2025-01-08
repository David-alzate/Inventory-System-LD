package co.inventory.system.ld.application.primaryports.interactor.products.impl.producttype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.interactor.products.producttype.DeleteProductTypeInteractor;
import co.inventory.system.ld.application.usecase.products.producttype.DeleteProductType;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteProductTypeInteractorImpl implements DeleteProductTypeInteractor {

	private final DeleteProductType deleteProductType;

	public DeleteProductTypeInteractorImpl(DeleteProductType deleteProductType) {
		this.deleteProductType = deleteProductType;
	}

	@Override
	public void execute(UUID data) {
		deleteProductType.execute(data);

	}

}
