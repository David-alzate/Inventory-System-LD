package co.inventory.system.ld.application.secondaryports.mapper.users;


import co.inventory.system.ld.application.secondaryports.entity.users.UserTypeEntity;
import co.inventory.system.ld.domain.users.UserTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserTypeEntityMapper {

    UserTypeEntityMapper INSTANCE = Mappers.getMapper(UserTypeEntityMapper.class);

    UserTypeEntity toEntity(UserTypeDomain domain);

    UserTypeDomain toDomain(UserTypeEntity entity);

    List<UserTypeEntity> toEntityCollection(List<UserTypeDomain> domainCollection);

    List<UserTypeDomain> toDomainCollection(List<UserTypeEntity> entityCollection);
}
