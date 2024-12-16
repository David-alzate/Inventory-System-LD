package co.inventory.system.ld.domain.commons.rules.idtype.impl;

import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.domain.commons.exceptions.idtype.IdTypeIdIsDefaultValueException;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdTypeIdIsNotDefaultValueRuleImpl implements IdTypeIdIsNotDefaultValueRule {

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw IdTypeIdIsDefaultValueException.create();
        }
    }
}
