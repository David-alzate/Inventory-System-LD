package co.inventory.system.ld.application.usecase.inventorymovements.impl;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.InventoryMovementEntity;
import co.inventory.system.ld.application.secondaryports.mapper.inventorymovements.MovementTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.products.ProductEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.InventoryMovementsRepository;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.RegisterNewInventoryMovement;
import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewInventoryMovementImpl implements RegisterNewInventoryMovement {
    private final RegisterNewInventoryMovementRulesValidator registerNewInventoryMovementRulesValidator;
    private final InventoryMovementsRepository inventoryMovementsRepository;

    public RegisterNewInventoryMovementImpl(RegisterNewInventoryMovementRulesValidator registerNewInventoryMovementRulesValidator, InventoryMovementsRepository inventoryMovementsRepository) {
        this.registerNewInventoryMovementRulesValidator = registerNewInventoryMovementRulesValidator;
        this.inventoryMovementsRepository = inventoryMovementsRepository;
    }

    @Override
    public void execute(InventoryMovementDomain domain) {
        registerNewInventoryMovementRulesValidator.validate(domain);

        var inventoryMovementEntity= InventoryMovementEntity.create().setId(domain.getId()).setQuantity(domain.getQuantity())
                .setMovementType(MovementTypeEntityMapper.INSTANCE.toEntity(domain.getMovementType()))
                .setProduct(ProductEntityMapper.INSTANCE.toEntity(domain.getProduct()))
                .setUser(UserEntityMapper.INSTANCE.toEntity(domain.getUser()));

        inventoryMovementsRepository.save(inventoryMovementEntity);
    }
}
