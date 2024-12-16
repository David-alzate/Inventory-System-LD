package co.inventory.system.ld.application.usecase.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.mapper.users.UserTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserTypeRepository;
import co.inventory.system.ld.application.usecase.users.GetUserType;
import co.inventory.system.ld.domain.users.UserTypeDomain;

@Service
public class GetUserTypeImpl implements GetUserType{
	
	private final UserTypeRepository userTypeRepository;
	
	public GetUserTypeImpl(UserTypeRepository userTypeRepository) {
		this.userTypeRepository = userTypeRepository;
	}

	@Override
	public List<UserTypeDomain> execute(UserTypeDomain domain) {
		var userTypeEntity = UserTypeEntityMapper.INSTANCE.toEntity(domain);
		var results = userTypeRepository.findByFilter(userTypeEntity);
		return UserTypeEntityMapper.INSTANCE.toDomainCollection(results);
	}

}
