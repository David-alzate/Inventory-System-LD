package co.inventory.system.ld.application.usecase.sales.impl;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleEntity;
import co.inventory.system.ld.application.secondaryports.mapper.sales.SaleEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.sales.SaleRepository;
import co.inventory.system.ld.application.usecase.sales.RegisterNewSale;
import co.inventory.system.ld.domain.sales.SaleDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewSaleImpl implements RegisterNewSale {

    private final SaleRepository saleRepository;

    public RegisterNewSaleImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public void execute(SaleDomain domain) {
        SaleEntity saleEntity = SaleEntityMapper.INSTANCE.toEntity(domain);
        saleRepository.save(saleEntity);
    }
}
