package co.inventory.system.ld.application.primaryports.mapper.users;

import co.inventory.system.ld.application.primaryports.dto.users.UserTypeDTO;
import co.inventory.system.ld.domain.users.UserTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserTypeDTOMapper {

    UserTypeDTOMapper INSTANCE = Mappers.getMapper(UserTypeDTOMapper.class);

    UserTypeDomain toDomain(UserTypeDTO dto);

    UserTypeDTO toDTO(UserTypeDomain domain);

    List<UserTypeDTO> toDTOCollection(List<UserTypeDomain> domain);
}
