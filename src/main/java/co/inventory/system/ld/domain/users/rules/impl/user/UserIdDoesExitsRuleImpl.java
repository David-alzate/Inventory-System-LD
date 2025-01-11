package co.inventory.system.ld.domain.users.rules.impl.user;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.domain.users.exceptions.user.UserIdDoesNotExistsException;
import co.inventory.system.ld.domain.users.rules.user.UserIdDoesExitsRule;

@Service
public class UserIdDoesExitsRuleImpl implements UserIdDoesExitsRule {

	private final UserRepository userRepository;

	public UserIdDoesExitsRuleImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void validate(UUID data) {
		if (!userRepository.existsById(data)) {
			throw UserIdDoesNotExistsException.create();
		}

	}

}
