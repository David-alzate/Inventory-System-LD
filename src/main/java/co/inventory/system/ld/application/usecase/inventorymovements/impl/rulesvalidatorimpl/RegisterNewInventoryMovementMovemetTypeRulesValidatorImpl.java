package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementMovemetTypeRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import co.inventory.system.ld.domain.inventorymovements.rules.movementtype.MovementTypeIdDoesExistsRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewInventoryMovementMovemetTypeRulesValidatorImpl implements RegisterNewInventoryMovementMovemetTypeRulesValidator {

    private MovementTypeIdDoesExistsRule movementTypeIdDoesExistsRule;

    public RegisterNewInventoryMovementMovemetTypeRulesValidatorImpl(MovementTypeIdDoesExistsRule movementTypeIdDoesExistsRule) {
        this.movementTypeIdDoesExistsRule = movementTypeIdDoesExistsRule;
    }

    @Override
    public void validate(InventoryMovementDomain data) {
        movementTypeIdDoesExistsRule.validate(data.getMovementType().getId());
    }
}
