package co.inventory.system.ld.application.secondaryports.mapper.inventorymovements;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.MovementTypeEntity;
import co.inventory.system.ld.domain.inventorymovements.MovementTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovementTypeEntityMapper {

    MovementTypeEntityMapper INSTANCE = Mappers.getMapper(MovementTypeEntityMapper.class);

    MovementTypeEntity toEntity(MovementTypeDomain domain);

    MovementTypeDomain toDomain(MovementTypeEntity entity);

    List<MovementTypeEntity> toEntityCollection(List<MovementTypeDomain> domainCollection);

    List<MovementTypeDomain> toDomainCollection(List<MovementTypeEntity> entityCollection);
}
