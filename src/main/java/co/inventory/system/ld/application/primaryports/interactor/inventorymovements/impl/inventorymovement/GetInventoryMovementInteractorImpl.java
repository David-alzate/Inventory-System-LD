package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.impl.inventorymovement;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.InventoryMovementDTO;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement.GetInventoryMovementInteractor;
import co.inventory.system.ld.application.primaryports.mapper.inventorymovements.InventoryMovementDTOMapper;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.GetInventoryMovement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInventoryMovementInteractorImpl implements GetInventoryMovementInteractor {

    private GetInventoryMovement getInventoryMovement;

    public GetInventoryMovementInteractorImpl(GetInventoryMovement getInventoryMovement) {
        this.getInventoryMovement = getInventoryMovement;
    }

    @Override
    public List<InventoryMovementDTO> execute(InventoryMovementDTO data) {
        var inventoryMovementDoimain = InventoryMovementDTOMapper.INSTANCE.toDomain(data);
        var results = getInventoryMovement.execute(inventoryMovementDoimain);
        return InventoryMovementDTOMapper.INSTANCE.toDTOCollection(results);
    }
}
