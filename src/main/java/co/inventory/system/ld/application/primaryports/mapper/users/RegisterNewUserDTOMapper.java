package co.inventory.system.ld.application.primaryports.mapper.users;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.domain.users.UserDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterNewUserDTOMapper {

    RegisterNewUserDTOMapper INSTANCE = Mappers.getMapper(RegisterNewUserDTOMapper.class);

    UserDomain toDomain(RegisterNewUserDTO dto);

    RegisterNewUserDTO toDTO(UserDomain domain);

    List<RegisterNewUserDTO> toDTOCollection(List<UserDomain> domain);
}
