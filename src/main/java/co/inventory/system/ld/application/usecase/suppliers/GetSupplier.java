package co.inventory.system.ld.application.usecase.suppliers;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

import java.util.List;

public interface GetSupplier extends UseCaseWithReturn<SupplierDomain, List <SupplierDomain>>{

}
