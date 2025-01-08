package co.inventory.system.ld.application.usecase.inventorymovements.movementtype;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.inventorymovements.MovementTypeDomain;

import java.util.List;

public interface GetMovementType extends UseCaseWithReturn <MovementTypeDomain, List<MovementTypeDomain>> {
}
