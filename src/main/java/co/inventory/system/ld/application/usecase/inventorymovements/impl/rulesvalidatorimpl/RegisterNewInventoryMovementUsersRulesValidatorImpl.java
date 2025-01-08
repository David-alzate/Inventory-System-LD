package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementUsersRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewInventoryMovementUsersRulesValidatorImpl implements RegisterNewInventoryMovementUsersRulesValidator {

    //Falta la rule de users
    @Override
    public void validate(InventoryMovementDomain data) {

    }
}
