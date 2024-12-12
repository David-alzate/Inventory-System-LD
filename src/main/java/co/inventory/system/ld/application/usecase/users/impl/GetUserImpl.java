package co.inventory.system.ld.application.usecase.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.mapper.users.UserEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.application.usecase.users.GetUser;
import co.inventory.system.ld.domain.users.UserDomain;

@Service
public class GetUserImpl implements GetUser {

	private UserRepository userRepository;

	public GetUserImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDomain> execute(UserDomain domain) {
		var userEntity = UserEntityMapper.INSTANCE.toEntity(domain);
		var results = userRepository.findByFilter(userEntity);
		return UserEntityMapper.INSTANCE.toDomainCollection(results);
	}

}
