package co.inventory.system.ld.domain.inventorymovements.rules.impl.inventorymovement;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement.InventoryMovementIdIsNullException;
import co.inventory.system.ld.domain.inventorymovements.rules.inventorymovement.InventoryMovementIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryMovementIdIsNotNullRuleImpl implements InventoryMovementIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw InventoryMovementIdIsNullException.create();
        }
    }
}
