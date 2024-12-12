package co.inventory.system.ld.application.secondaryports.mapper.users;


import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.domain.users.UserDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    UserEntity toEntity(UserDomain domain);

    UserDomain toDomain(UserEntity entity);

    List<UserEntity> toEntityCollection(List<UserDomain> domainCollection);

    List<UserDomain> toDomainCollection(List<UserEntity> entityCollection);
}
