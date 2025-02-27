package co.inventory.system.ld.domain.inventorymovements.rules.impl.inventorymovement;

import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.InventoryMovementsRepository;
import co.inventory.system.ld.domain.inventorymovements.exceptions.inventorymovement.InventoryMovementIdDoesExistsException;
import co.inventory.system.ld.domain.inventorymovements.rules.inventorymovement.InventoryMovementIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryMovementIdDoesNotExistsRuleImpl  implements InventoryMovementIdDoesNotExistsRule {

    private InventoryMovementsRepository inventoryMovementsRepository;

    public InventoryMovementIdDoesNotExistsRuleImpl(InventoryMovementsRepository movementsRepository) {
        this.inventoryMovementsRepository = movementsRepository;
    }
    @Override
    public void validate(UUID data) {
        if (inventoryMovementsRepository.existsById(data)){
            throw InventoryMovementIdDoesExistsException.create();
        }
    }
}
