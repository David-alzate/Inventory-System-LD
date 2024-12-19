package co.inventory.system.ld.application.primaryports.mapper.users;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.domain.users.UserDomain;

@Mapper
public interface RegisterNewUserDTOMapper {

	RegisterNewUserDTOMapper INSTANCE = Mappers.getMapper(RegisterNewUserDTOMapper.class);

	@Mapping(target = "id", ignore = true)
	UserDomain toDomain(RegisterNewUserDTO dto);

	RegisterNewUserDTO toDTO(UserDomain domain);

	List<RegisterNewUserDTO> toDTOCollection(List<UserDomain> domain);
}
