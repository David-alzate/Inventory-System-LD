package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.*;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewInventoryMovementRulesValidatorImpl implements RegisterNewInventoryMovementRulesValidator {

    private RegisterNewInventoryMovementIdRulesValidator registerNewInventoryMovementIdRulesValidator;
    private RegisterNewInventoryMovementMovemetTypeRulesValidator registerNewInventoryMovementMovemetTypeRulesValidator;
    private RegisterNewInventoryMovementProductsRulesValidator registerNewInventoryMovementProductsRulesValidator;
    private RegisterNewInventoryMovementUsersRulesValidator registerNewInventoryMovementUsersRulesValidator;

    public RegisterNewInventoryMovementRulesValidatorImpl(RegisterNewInventoryMovementIdRulesValidator registerNewInventoryMovementIdRulesValidator, RegisterNewInventoryMovementMovemetTypeRulesValidator registerNewInventoryMovementMovemetTypeRulesValidator, RegisterNewInventoryMovementProductsRulesValidator registerNewInventoryMovementProductsRulesValidator, RegisterNewInventoryMovementUsersRulesValidator registerNewInventoryMovementUsersRulesValidator) {
        this.registerNewInventoryMovementIdRulesValidator = registerNewInventoryMovementIdRulesValidator;
        this.registerNewInventoryMovementMovemetTypeRulesValidator = registerNewInventoryMovementMovemetTypeRulesValidator;
        this.registerNewInventoryMovementProductsRulesValidator = registerNewInventoryMovementProductsRulesValidator;
        this.registerNewInventoryMovementUsersRulesValidator = registerNewInventoryMovementUsersRulesValidator;
    }

    @Override
    public void validate(InventoryMovementDomain data) {
        registerNewInventoryMovementIdRulesValidator.validate(data);
        registerNewInventoryMovementMovemetTypeRulesValidator.validate(data);
        registerNewInventoryMovementProductsRulesValidator.validate(data);
        registerNewInventoryMovementUsersRulesValidator.validate(data);
    }
}
