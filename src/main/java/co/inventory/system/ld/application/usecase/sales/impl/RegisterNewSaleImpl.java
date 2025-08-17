package co.inventory.system.ld.application.usecase.sales.impl;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleEntity;
import co.inventory.system.ld.application.secondaryports.mapper.sales.SaleEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.sales.SaleStatusEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.secondaryports.repository.sales.SaleRepository;
import co.inventory.system.ld.application.usecase.sales.RegisterNewSale;
import co.inventory.system.ld.application.usecase.sales.rulesvalidator.RegisterNewSaleRulesValidator;
import co.inventory.system.ld.crosscutting.enums.SaleStatusEnum;
import co.inventory.system.ld.domain.sales.SaleDomain;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RegisterNewSaleImpl implements RegisterNewSale {

    private final SaleRepository saleRepository;
    private final ProductsRepository productsRepository;
    private final RegisterNewSaleRulesValidator registerNewSaleRulesValidator;

    public RegisterNewSaleImpl(SaleRepository saleRepository, ProductsRepository productsRepository, RegisterNewSaleRulesValidator registerNewSaleRulesValidator) {
        this.saleRepository = saleRepository;
        this.productsRepository = productsRepository;
        this.registerNewSaleRulesValidator = registerNewSaleRulesValidator;
    }

    @Override
    public UUID execute(SaleDomain domain) {
        registerNewSaleRulesValidator.validate(domain);

        SaleEntity saleEntity = SaleEntity.create()
                .setUser(UserEntityMapper.INSTANCE.toEntity(domain.getUser()))
                .setOrderDate(LocalDateTime.now().withSecond(0).withNano(0))
                .setSaleStatus(SaleStatusEntityMapper.INSTANCE.toEntity(domain.getSaleStatus()).setId(SaleStatusEnum.PENDING.getId()))
                .setSaleProducts(new ArrayList<>());

        return null;
    }
}
