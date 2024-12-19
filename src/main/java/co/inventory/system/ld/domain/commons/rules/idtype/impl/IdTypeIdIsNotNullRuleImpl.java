package co.inventory.system.ld.domain.commons.rules.idtype.impl;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.commons.exceptions.idtype.IdTypeIdIsNullException;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdTypeIdIsNotNullRuleImpl implements IdTypeIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw IdTypeIdIsNullException.create();
        }
    }
}
