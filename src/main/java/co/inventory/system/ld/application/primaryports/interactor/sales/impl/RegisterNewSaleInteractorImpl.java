package co.inventory.system.ld.application.primaryports.interactor.sales.impl;

import co.inventory.system.ld.application.primaryports.dto.sales.SaleDTO;
import co.inventory.system.ld.application.primaryports.interactor.sales.RegisterNewSaleInteractor;
import co.inventory.system.ld.application.primaryports.mapper.sales.SaleDTOMapper;
import co.inventory.system.ld.application.usecase.sales.RegisterNewSale;
import co.inventory.system.ld.domain.sales.SaleDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterNewSaleInteractorImpl implements RegisterNewSaleInteractor {

    private final RegisterNewSale registerNewSale;

    public RegisterNewSaleInteractorImpl(RegisterNewSale registerNewSale) {
        this.registerNewSale = registerNewSale;
    }

    @Override
    public void execute(SaleDTO data) {
        SaleDomain saleDomain = SaleDTOMapper.INSTANCE.toDomain(data);
        registerNewSale.execute(saleDomain);
    }
}
