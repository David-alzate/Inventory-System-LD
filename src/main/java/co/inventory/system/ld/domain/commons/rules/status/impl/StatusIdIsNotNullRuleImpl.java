package co.inventory.system.ld.domain.commons.rules.status.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.commons.exceptions.status.StatusIdIsNullException;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StatusIdIsNotNullRuleImpl implements StatusIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw StatusIdIsNullException.create();
        }
    }
}
