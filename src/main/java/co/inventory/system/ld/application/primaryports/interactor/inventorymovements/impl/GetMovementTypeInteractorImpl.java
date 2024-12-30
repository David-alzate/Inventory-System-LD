package co.inventory.system.ld.application.primaryports.interactor.inventorymovements.impl;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.MovementTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.GetMovementTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.inventorymovements.MovementTypeDTOMapper;
import co.inventory.system.ld.application.usecase.inventorymovements.GetMovementType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetMovementTypeInteractorImpl implements GetMovementTypeInteractor {

    private GetMovementType getMovementType;

    public GetMovementTypeInteractorImpl(GetMovementType getMovementType) {
        this.getMovementType = getMovementType;
    }

    @Override
    public List<MovementTypeDTO> execute(MovementTypeDTO data) {
        var movementTypeDomain= MovementTypeDTOMapper.INSTANCE.toDomain(data);
        var results= getMovementType.execute(movementTypeDomain);
        return MovementTypeDTOMapper.INSTANCE.toDTOCollection(results);
    }
}
