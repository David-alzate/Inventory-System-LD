package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.impl.inventorymovement;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.RegisterNewInventoryMovementDTO;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement.RegisterNewInventoryMovementInteractor;
import co.inventory.system.ld.application.primaryports.mapper.inventorymovements.RegisterNewInventoryMovementDTOMapper;
import co.inventory.system.ld.application.usecase.inventorymovements.inventorymovement.RegisterNewInventoryMovement;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewInventoryMovementInteractorImpl implements RegisterNewInventoryMovementInteractor {

    private final RegisterNewInventoryMovement  registerNewInventoryMovement;

    public RegisterNewInventoryMovementInteractorImpl(RegisterNewInventoryMovement registerNewInventoryMovement) {
        this.registerNewInventoryMovement = registerNewInventoryMovement;
    }

    @Override
    public void execute(RegisterNewInventoryMovementDTO data) {
        try {
            var inventoryMovementDomain= RegisterNewInventoryMovementDTOMapper.INSTANCE.toDomain(data);
            registerNewInventoryMovement.execute(inventoryMovementDomain);
        }catch (InventorySystemException exception){
            throw exception;
        }catch (Exception exception){
            var userMessage = "No se ha podido registrar el movimiento de inventario";
            var technicalMessage = "Ha ocurrido un error inesperado tratando de registrar el movimiento de inventario";

            throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);
        }
    }
}
