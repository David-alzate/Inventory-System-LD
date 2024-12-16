package co.inventory.system.ld.application.primaryports.interactor.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.GetUserInteractor;
import co.inventory.system.ld.application.primaryports.mapper.users.UserDTOMapper;
import co.inventory.system.ld.application.usecase.users.GetUser;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GetUserInteractorImpl implements GetUserInteractor {

	private final GetUser getUser;

	public GetUserInteractorImpl(GetUser getUser) {
		this.getUser = getUser;
	}

	@Override
	public List<UserDTO> execute(UserDTO data) {
		var userDomain = UserDTOMapper.INSTANCE.toDomain(data);
		var results = getUser.execute(userDomain);
		return UserDTOMapper.INSTANCE.toDTOCollection(results);
	}

}
