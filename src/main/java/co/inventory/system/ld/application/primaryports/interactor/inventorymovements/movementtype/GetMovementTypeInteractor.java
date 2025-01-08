package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.movementtype;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.MovementTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

import java.util.List;

public interface GetMovementTypeInteractor extends InteractorWithReturn<MovementTypeDTO, List<MovementTypeDTO>> {
}
