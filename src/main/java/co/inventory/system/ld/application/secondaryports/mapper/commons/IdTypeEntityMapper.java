package co.inventory.system.ld.application.secondaryports.mapper.commons;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;
import co.inventory.system.ld.domain.commons.IdTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface IdTypeEntityMapper {

    IdTypeEntityMapper INSTANCE = Mappers.getMapper(IdTypeEntityMapper.class);

    IdTypeEntity toEntity(IdTypeDomain domain);

    IdTypeDomain toDomain(IdTypeEntity entity);

    List<IdTypeEntity> toEntityCollection(List<IdTypeDomain> domainCollection);

    List<IdTypeDomain> toDomainCollection(List<IdTypeEntity> entityCollection);
}
