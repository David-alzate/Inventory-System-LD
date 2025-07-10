package co.inventory.system.ld.domain.sales.rules.impl;

import co.inventory.system.ld.application.secondaryports.repository.sales.SaleStatusRepository;
import co.inventory.system.ld.domain.sales.exceptions.SaleStatusDoesNotExistsException;
import co.inventory.system.ld.domain.sales.rules.SaleStatusDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SaleStatusDoesExistsRuleImpl implements SaleStatusDoesExistsRule {

    private final SaleStatusRepository saleStatusRepository;

    public SaleStatusDoesExistsRuleImpl(SaleStatusRepository repository) {
        this.saleStatusRepository = repository;
    }

    @Override
    public void validate(UUID data) {
        if (!saleStatusRepository.existsById(data)) {
            throw SaleStatusDoesNotExistsException.create();
        }
    }
}
