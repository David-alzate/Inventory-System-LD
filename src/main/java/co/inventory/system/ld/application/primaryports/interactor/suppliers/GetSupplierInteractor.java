package co.inventory.system.ld.application.primaryports.interactor.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

import java.util.List;

public interface GetSupplierInteractor extends InteractorWithReturn <SupplierDTO, List<SupplierDTO>> {
}
