package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementIdRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement.InventoryMovementIdDoesExistsException;
import co.inventory.system.ld.domain.inventorymovements.rules.inventorymovement.InventoryMovementIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewInventoryMovementIdRulesValidatorImpl implements RegisterNewInventoryMovementIdRulesValidator {

    private InventoryMovementIdDoesNotExistsRule inventoryMovementIdDoesNotExistsRule;

    public RegisterNewInventoryMovementIdRulesValidatorImpl(InventoryMovementIdDoesNotExistsRule inventoryMovementIdDoesNotExistsRule) {
        this.inventoryMovementIdDoesNotExistsRule = inventoryMovementIdDoesNotExistsRule;
    }

    @Override
    public void validate(InventoryMovementDomain data) {
        data.generateId();
        try {
            inventoryMovementIdDoesNotExistsRule.validate(data.getId());
        }catch (final InventoryMovementIdDoesExistsException exception){
            validate(data);
        }
    }
}
