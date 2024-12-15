package co.inventory.system.ld.application.primaryports.interactor.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.users.UserTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.GetUserTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.users.UserTypeDTOMapper;
import co.inventory.system.ld.application.usecase.users.GetUserType;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GetUserTypeInteractorImpl implements GetUserTypeInteractor {

	private GetUserType getUserType;

	public GetUserTypeInteractorImpl(GetUserType getUserType) {
		this.getUserType = getUserType;
	}

	@Override
	public List<UserTypeDTO> execute(UserTypeDTO data) {
		var userDomain = UserTypeDTOMapper.INSTANCE.toDomain(data);
		var results = getUserType.execute(userDomain);
		return UserTypeDTOMapper.INSTANCE.toDTOCollection(results);
	}

}
