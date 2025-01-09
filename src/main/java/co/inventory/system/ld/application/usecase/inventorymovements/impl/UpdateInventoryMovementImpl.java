package co.inventory.system.ld.application.usecase.inventorymovements.impl;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.InventoryMovementEntity;
import co.inventory.system.ld.application.secondaryports.mapper.inventorymovements.MovementTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.products.ProductEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.InventoryMovementsRepository;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.UpdateInventoryMovement;
import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.UpdateInventoryMovementRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateInventoryMovementImpl implements UpdateInventoryMovement {

    private InventoryMovementsRepository  inventoryMovementsRepository;
    private UpdateInventoryMovementRulesValidator  updateInventoryMovementRulesValidator;

    public UpdateInventoryMovementImpl(InventoryMovementsRepository inventoryMovementsRepository, UpdateInventoryMovementRulesValidator updateInventoryMovementRulesValidator) {
        this.inventoryMovementsRepository = inventoryMovementsRepository;
        this.updateInventoryMovementRulesValidator = updateInventoryMovementRulesValidator;
    }

    @Override
    public void execute(InventoryMovementDomain domain) {

       updateInventoryMovementRulesValidator.validate(domain);

        var inventoryMovementEntity= InventoryMovementEntity.create().setId(domain.getId()).setQuantity(domain.getQuantity())
                .setMovementType(MovementTypeEntityMapper.INSTANCE.toEntity(domain.getMovementType()))
                .setProduct(ProductEntityMapper.INSTANCE.toEntity(domain.getProduct()))
                .setUser(UserEntityMapper.INSTANCE.toEntity(domain.getUser()));

        inventoryMovementsRepository.save(inventoryMovementEntity);
    }
}
