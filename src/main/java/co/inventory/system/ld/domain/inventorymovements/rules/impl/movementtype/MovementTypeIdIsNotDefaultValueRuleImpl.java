package co.inventory.system.ld.domain.inventorymovements.rules.impl.movementtype;

import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.domain.inventorymovements.exceptions.movementtype.MovementTypeIdIsDefaultValueException;
import co.inventory.system.ld.domain.inventorymovements.rules.movementtype.MovementTypeIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovementTypeIdIsNotDefaultValueRuleImpl implements MovementTypeIdIsNotDefaultValueRule {

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw MovementTypeIdIsDefaultValueException.create();
        }
    }
}
