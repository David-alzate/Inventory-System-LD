package co.inventory.system.ld.application.usecase.inventorymovements.impl;

import co.inventory.system.ld.application.secondaryports.mapper.inventorymovements.MovementTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.inventorymovements.MovementTypeRepository;
import co.inventory.system.ld.application.usecase.inventorymovements.GetMovementType;
import co.inventory.system.ld.domain.inventorymovements.MovementTypeDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMovementTypeImpl implements GetMovementType {

    private MovementTypeRepository movementTypeRepository;

    public GetMovementTypeImpl(MovementTypeRepository movementTypeRepository) {
        this.movementTypeRepository = movementTypeRepository;
    }

    @Override
    public List<MovementTypeDomain> execute(MovementTypeDomain domain) {
        var movementTypeEntity= MovementTypeEntityMapper.INSTANCE.toEntity(domain);
        var results= movementTypeRepository.findByFilter(movementTypeEntity);
        return MovementTypeEntityMapper.INSTANCE.toDomainCollection(results);
    }
}
