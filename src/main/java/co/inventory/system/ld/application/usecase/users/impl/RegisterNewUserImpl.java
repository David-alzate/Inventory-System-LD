package co.inventory.system.ld.application.usecase.users.impl;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;
import co.inventory.system.ld.application.secondaryports.entity.users.UserTypeEntity;
import co.inventory.system.ld.crosscutting.enums.StatusEnum;
import co.inventory.system.ld.crosscutting.enums.UserTypeEnum;
import co.inventory.system.ld.crosscutting.helpers.JwtHelper;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.AuthResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.application.secondaryports.mapper.commons.IdTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.commons.StatusEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.application.usecase.users.RegisterNewUser;
import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterNewUserImpl implements RegisterNewUser {

	private final UserRepository userRepository;
	private final RegisterNewUserRulesValidator registerNewUserRulesValidator;
	private final JwtHelper jwtHelper;
	private final PasswordEncoder passwordEncoder;

    public RegisterNewUserImpl(UserRepository userRepository, RegisterNewUserRulesValidator registerNewUserRulesValidator, JwtHelper jwtHelper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.registerNewUserRulesValidator = registerNewUserRulesValidator;
        this.jwtHelper = jwtHelper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
	public AuthResponse execute(UserDomain domain) {

        registerNewUserRulesValidator.validate(domain);

		String encodedPassword = passwordEncoder.encode(domain.getPassword());

		var userEntity = UserEntity.create().setId(domain.getId())
				.setName(domain.getName())
				.setLastName(domain.getLastName())
				.setIdType(IdTypeEntityMapper.INSTANCE.toEntity(domain.getIdType()))
				.setIdNumber(domain.getIdNumber())
				.setEmail(domain.getEmail())
				.setUserType(UserTypeEntity.create().setId(domain.getUserType().getId()))
				.setStatus(StatusEntity.create().setId(StatusEnum.ACTIVE.getId()))
				.setPassword(encodedPassword);

		userRepository.save(userEntity);

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getUserType().getName()));

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userEntity.getEmail(), null, authorities);

		String accessToken = jwtHelper.createToken(authenticationToken);

		var authResponse = new AuthResponse();
		authResponse.setToken(accessToken);
		authResponse.setRole(userEntity.getUserType().getName());
		authResponse.getMessages().add("User registered successfully");
		return authResponse;
	}
}
