package co.inventory.system.ld.domain.inventorymovements.rules.impl.movementtype;

import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.MovementTypeRepository;
import co.inventory.system.ld.domain.inventorymovements.exceptions.movementtype.MovementTypeIdDoesNotExistsException;
import co.inventory.system.ld.domain.inventorymovements.rules.movementtype.MovementTypeIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovementTypeIdDoesExistsRuleImpl implements MovementTypeIdDoesExistsRule {

    private MovementTypeRepository movementTypeRepository;

    public MovementTypeIdDoesExistsRuleImpl(MovementTypeRepository movementTypeRepository) {
        this.movementTypeRepository = movementTypeRepository;
    }

    @Override
    public void validate(UUID data) {
        if (!movementTypeRepository.existsById(data)) {
            throw MovementTypeIdDoesNotExistsException.create();
        }
    }
}
