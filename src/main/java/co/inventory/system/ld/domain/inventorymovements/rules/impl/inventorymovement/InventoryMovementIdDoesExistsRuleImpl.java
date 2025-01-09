package co.inventory.system.ld.domain.inventorymovements.rules.impl.inventorymovement;

import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.InventoryMovementsRepository;
import co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement.InventoryMovementIdDoesExistsException;
import co.inventory.system.ld.domain.inventorymovements.rules.inventorymovement.InventoryMovementIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryMovementIdDoesExistsRuleImpl implements InventoryMovementIdDoesExistsRule {

    private InventoryMovementsRepository inventoryMovementsRepository;

    public InventoryMovementIdDoesExistsRuleImpl(InventoryMovementsRepository inventoryMovementsRepository) {
        this.inventoryMovementsRepository = inventoryMovementsRepository;
    }

    @Override
    public void validate(UUID data) {
        if (!inventoryMovementsRepository.existsById(data)) {
            throw InventoryMovementIdDoesExistsException.create();
        }
    }
}
