package co.inventory.system.ld.application.primaryports.interactor.products.impl.product;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.interactor.products.product.DeleteProductInteractor;
import co.inventory.system.ld.application.usecase.products.product.DeleteProduct;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteProductInteractorImpl implements DeleteProductInteractor {

	private final DeleteProduct deleteProduct;

	public DeleteProductInteractorImpl(DeleteProduct deleteProduct) {
		this.deleteProduct = deleteProduct;
	}

	@Override
	public void execute(UUID data) {
		deleteProduct.execute(data);
	}

}
