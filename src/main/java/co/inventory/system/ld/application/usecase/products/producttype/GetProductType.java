package co.inventory.system.ld.application.usecase.products.producttype;

import java.util.List;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

public interface GetProductType extends UseCaseWithReturn<ProductTypeDomain, List<ProductTypeDomain>>{

}
