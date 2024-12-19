package co.inventory.system.ld.domain.commons.rules.status.impl;

import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.domain.commons.exceptions.status.StatusIdIsDefaultValueException;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class StatusIdIsNotDefaultValueRuleImpl implements StatusIdIsNotDefaultValueRule {

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw StatusIdIsDefaultValueException.create();
        }
    }
}
