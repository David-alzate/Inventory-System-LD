package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.impl.inventorymovement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.InventoryMovementDTO;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement.UpdateInventoryMovementInteractor;
import co.inventory.system.ld.application.primaryports.mapper.inventorymovements.InventoryMovementDTOMapper;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.UpdateInventoryMovement;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;

@Service
@Transactional
public class UpdateInventoryMovementInteractorImpl implements UpdateInventoryMovementInteractor {

    private UpdateInventoryMovement  updateInventoryMovement;

    public UpdateInventoryMovementInteractorImpl(UpdateInventoryMovement updateInventoryMovement) {
        this.updateInventoryMovement = updateInventoryMovement;
    }

    @Override
    public void execute(InventoryMovementDTO data) {
        try {
            var inventoryMovementDomain= InventoryMovementDTOMapper.INSTANCE.toDomain(data);
            updateInventoryMovement.execute(inventoryMovementDomain);
        }catch (InventorySystemException exception){
            throw exception;
        }catch (Exception exception){
            var userMessage = "No se ha podido actualizar el movimiento de inventario";
            var technicalMessage = "Ha ocurrido un error inesperado tratando de actualizar el movimiento de inventario";

            throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);
        }
    }
}
