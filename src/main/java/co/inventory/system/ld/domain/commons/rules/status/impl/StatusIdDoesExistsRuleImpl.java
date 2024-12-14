package co.inventory.system.ld.domain.commons.rules.status.impl;

import co.inventory.system.ld.application.secondaryports.repository.commons.StatusRepository;
import co.inventory.system.ld.domain.commons.exceptions.status.StatusIdDoesNotExistsException;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StatusIdDoesExistsRuleImpl implements StatusIdDoesExistsRule {

    private final StatusRepository statusRepository;

    public StatusIdDoesExistsRuleImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void validate(UUID data) {
        if (!statusRepository.existsById(data)) {
            throw StatusIdDoesNotExistsException.create();
        }
    }
}
