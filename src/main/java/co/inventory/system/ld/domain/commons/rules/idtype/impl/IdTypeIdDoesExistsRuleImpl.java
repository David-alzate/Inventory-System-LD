package co.inventory.system.ld.domain.commons.rules.idtype.impl;

import co.inventory.system.ld.application.secondaryports.repository.commons.IdTypeRepository;
import co.inventory.system.ld.domain.commons.exceptions.idtype.IdTypeIdDoesNotExistsException;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdTypeIdDoesExistsRuleImpl implements IdTypeIdDoesExistsRule {

    private final IdTypeRepository idTypeRepository;

    public IdTypeIdDoesExistsRuleImpl(IdTypeRepository idTypeRepository) {
        this.idTypeRepository = idTypeRepository;
    }

    @Override
    public void validate(UUID data) {
        if (!idTypeRepository.existsById(data)) {
            throw IdTypeIdDoesNotExistsException.create();
        }
    }
}
