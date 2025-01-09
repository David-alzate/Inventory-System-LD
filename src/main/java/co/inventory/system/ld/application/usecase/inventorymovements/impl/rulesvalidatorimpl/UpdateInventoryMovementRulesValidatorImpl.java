package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementMovemetTypeRulesValidator;
import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementProductsRulesValidator;
import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementUsersRulesValidator;
import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.UpdateInventoryMovementRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import co.inventory.system.ld.domain.inventorymovements.rules.inventorymovement.InventoryMovementIdDoesExistsRule;
import org.springframework.stereotype.Service;

@Service
public class UpdateInventoryMovementRulesValidatorImpl implements UpdateInventoryMovementRulesValidator {

    private InventoryMovementIdDoesExistsRule inventoryMovementIdDoesExistsRule;
    private RegisterNewInventoryMovementMovemetTypeRulesValidator registerNewInventoryMovementMovemetTypeRulesValidator;
    private RegisterNewInventoryMovementProductsRulesValidator registerNewInventoryMovementProductsRulesValidator;
    private RegisterNewInventoryMovementUsersRulesValidator registerNewInventoryMovementUsersRulesValidator;

    public UpdateInventoryMovementRulesValidatorImpl(InventoryMovementIdDoesExistsRule inventoryMovementIdDoesExistsRule, RegisterNewInventoryMovementMovemetTypeRulesValidator registerNewInventoryMovementMovemetTypeRulesValidator, RegisterNewInventoryMovementProductsRulesValidator registerNewInventoryMovementProductsRulesValidator, RegisterNewInventoryMovementUsersRulesValidator registerNewInventoryMovementUsersRulesValidator) {
        this.inventoryMovementIdDoesExistsRule = inventoryMovementIdDoesExistsRule;
        this.registerNewInventoryMovementMovemetTypeRulesValidator = registerNewInventoryMovementMovemetTypeRulesValidator;
        this.registerNewInventoryMovementProductsRulesValidator = registerNewInventoryMovementProductsRulesValidator;
        this.registerNewInventoryMovementUsersRulesValidator = registerNewInventoryMovementUsersRulesValidator;
    }

    @Override
    public void validate(InventoryMovementDomain data) {
        inventoryMovementIdDoesExistsRule.validate(data.getId());
        registerNewInventoryMovementMovemetTypeRulesValidator.validate(data);
        registerNewInventoryMovementProductsRulesValidator.validate(data);
        registerNewInventoryMovementUsersRulesValidator.validate(data);
    }
}
