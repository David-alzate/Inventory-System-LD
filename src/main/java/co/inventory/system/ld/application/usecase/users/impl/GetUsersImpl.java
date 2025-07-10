package co.inventory.system.ld.application.usecase.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.mapper.users.UserEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.application.usecase.users.GetUsers;
import co.inventory.system.ld.domain.users.UserDomain;

@Service
public class GetUsersImpl implements GetUsers {

	private UserRepository userRepository;

	public GetUsersImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDomain> execute(UserDomain domain) {
		var results = userRepository.findAll();
		return UserEntityMapper.INSTANCE.toDomainCollection(results);
	}
}
