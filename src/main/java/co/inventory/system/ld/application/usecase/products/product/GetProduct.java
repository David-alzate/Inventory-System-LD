package co.inventory.system.ld.application.usecase.products.product;

import java.util.List;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.products.ProductDomain;

public interface GetProduct extends UseCaseWithReturn<ProductDomain, List<ProductDomain>>{

}
