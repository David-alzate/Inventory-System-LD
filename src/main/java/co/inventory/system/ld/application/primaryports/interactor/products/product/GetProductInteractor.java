package co.inventory.system.ld.application.primaryports.interactor.products.product;

import java.util.List;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

public interface GetProductInteractor extends InteractorWithReturn<ProductDTO, List<ProductDTO>>{

}
