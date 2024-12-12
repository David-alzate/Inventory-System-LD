package co.inventory.system.ld.application.primaryports.mapper.users;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.domain.users.UserDomain;

@Mapper
public interface UserDTOMapper {

	UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

	UserDomain toDomain(UserDTO dto);

	UserDTO toDTO(UserDomain domain);

	List<UserDTO> toDTOCollection(List<UserDomain> domain);
}