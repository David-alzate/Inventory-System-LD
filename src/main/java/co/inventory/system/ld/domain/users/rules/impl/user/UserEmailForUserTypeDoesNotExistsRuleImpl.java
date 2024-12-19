package co.inventory.system.ld.domain.users.rules.impl.user;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.exceptions.user.UserEmailForUserTypeDoesExistsException;
import co.inventory.system.ld.domain.users.rules.user.UserEmailForUserTypeDoesNotExistsRule;

@Service
public class UserEmailForUserTypeDoesNotExistsRuleImpl implements UserEmailForUserTypeDoesNotExistsRule {

	private final UserRepository userRepository;

	public UserEmailForUserTypeDoesNotExistsRuleImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void validate(UserDomain data) {
		var userFilter = UserEntity.create().setEmail(data.getEmail());

		var results = userRepository.findByFilter(userFilter);

		if (!results.isEmpty()) {
			throw UserEmailForUserTypeDoesExistsException.create();
		}

	}

}
