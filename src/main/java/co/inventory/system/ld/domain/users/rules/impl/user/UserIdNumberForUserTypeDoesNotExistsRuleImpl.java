package co.inventory.system.ld.domain.users.rules.impl.user;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.exceptions.user.UserIdNumberForUserTypeDoesExistsException;
import co.inventory.system.ld.domain.users.rules.user.UserIdNumberForUserTypeDoesNotExistsRule;

@Service
public class UserIdNumberForUserTypeDoesNotExistsRuleImpl implements UserIdNumberForUserTypeDoesNotExistsRule {

	private final UserRepository userRepository;

	public UserIdNumberForUserTypeDoesNotExistsRuleImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void validate(UserDomain data) {

		var userFilter = UserEntity.create().setIdNumber(data.getIdNumber())
				.setUserType(UserTypeEntityMapper.INSTANCE.toEntity(data.getUserType()));

		var results = userRepository.findByFilter(userFilter);

		if (!results.isEmpty()) {
			throw UserIdNumberForUserTypeDoesExistsException.create();
		}

	}

}
