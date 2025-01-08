package co.inventory.system.ld.application.primaryports.interactor.suppliers.impl;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.application.primaryports.interactor.suppliers.GetSupplierInteractor;
import co.inventory.system.ld.application.primaryports.mapper.suppliers.SupplierDTOMapper;
import co.inventory.system.ld.application.usecase.suppliers.GetSupplier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class GetSupplierInteractorImpl implements GetSupplierInteractor {

    private final GetSupplier getSupplier;

    public GetSupplierInteractorImpl(GetSupplier getSupplier) {
        this.getSupplier = getSupplier;
    }

    @Override
    public List<SupplierDTO> execute(SupplierDTO data) {
        var supplierDomain= SupplierDTOMapper.INSTANCE.toDomain(data);
        var results= getSupplier.execute(supplierDomain);
        return SupplierDTOMapper.INSTANCE.toDTOCollection(results);
    }
}
