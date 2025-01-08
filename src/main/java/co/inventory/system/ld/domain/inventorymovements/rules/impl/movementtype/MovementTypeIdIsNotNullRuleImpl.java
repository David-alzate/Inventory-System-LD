package co.inventory.system.ld.domain.inventorymovements.rules.impl.movementtype;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.inventorymovements.exceptions.movementtype.MovementTypeIdIsNullException;
import co.inventory.system.ld.domain.inventorymovements.rules.movementtype.MovementTypeIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovementTypeIdIsNotNullRuleImpl implements MovementTypeIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw MovementTypeIdIsNullException.create();
        }
    }
}
