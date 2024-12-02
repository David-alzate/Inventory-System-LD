package co.inventory.system.ld.application.secondaryports.mapper.commons;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;
import co.inventory.system.ld.domain.commons.IdTypeDomain;
import co.inventory.system.ld.domain.commons.StatusDomain;

@Mapper
public interface StatusEntityMapper {

	StatusEntityMapper INSTANCE = Mappers.getMapper(StatusEntityMapper.class);

	StatusEntity toEntity(StatusDomain domain);

	IdTypeDomain toDomain(StatusEntity entity);

	List<StatusEntity> toEntityCollection(List<StatusDomain> domainCollection);

	List<StatusDomain> toDomainCollection(List<StatusEntity> entityCollection);

}
