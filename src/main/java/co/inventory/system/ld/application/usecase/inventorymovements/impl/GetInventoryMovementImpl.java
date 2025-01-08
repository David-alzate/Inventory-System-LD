package co.inventory.system.ld.application.usecase.inventorymovements.impl;

import co.inventory.system.ld.application.secondaryports.mapper.inventorymovements.InventoryMovementEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.InventoryMovementsRepository;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.GetInventoryMovement;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInventoryMovementImpl implements GetInventoryMovement {

    private InventoryMovementsRepository inventoryMovementsRepository;

    public GetInventoryMovementImpl(InventoryMovementsRepository inventoryMovementsRepository) {
        this.inventoryMovementsRepository = inventoryMovementsRepository;
    }

    @Override
    public List<InventoryMovementDomain> execute(InventoryMovementDomain domain) {
        var inventoryMovementEntity= InventoryMovementEntityMapper.INSTANCE.toEntity(domain);
        var results = inventoryMovementsRepository.findByFilter(inventoryMovementEntity);
        return  InventoryMovementEntityMapper.INSTANCE.toDomainCollection(results);
    }
}
