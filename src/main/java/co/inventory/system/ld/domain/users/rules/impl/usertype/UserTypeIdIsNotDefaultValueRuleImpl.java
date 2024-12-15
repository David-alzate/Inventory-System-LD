package co.inventory.system.ld.domain.users.rules.impl.usertype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.domain.users.exceptions.usertype.UserTypeIdIsDefaultValueException;
import co.inventory.system.ld.domain.users.rules.usertype.UserTypeIdIsNotDefaultValueRule;

@Service
public class UserTypeIdIsNotDefaultValueRuleImpl implements UserTypeIdIsNotDefaultValueRule{

	@Override
	public void validate(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw UserTypeIdIsDefaultValueException.create();
		}
		
	}

}
