package co.inventory.system.ld.domain.users.rules.impl.usertype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.users.UserTypeRepository;
import co.inventory.system.ld.domain.users.exceptions.usertype.UserTypeDoesNotExistException;
import co.inventory.system.ld.domain.users.rules.usertype.UserTypeDoesExistRule;

@Service
public class UserTypeDoesExistRuleImpl implements UserTypeDoesExistRule{
	
	private UserTypeRepository userTypeRepository;
	
	public UserTypeDoesExistRuleImpl(UserTypeRepository userTypeRepository) {
		this.userTypeRepository = userTypeRepository;
	}

	@Override
	public void validate(UUID data) {
		if (!userTypeRepository.existsById(data)) {
			throw UserTypeDoesNotExistException.create();
		}
		
	}

}
