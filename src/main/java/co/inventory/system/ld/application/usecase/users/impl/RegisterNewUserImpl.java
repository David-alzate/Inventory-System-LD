package co.inventory.system.ld.application.usecase.users.impl;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.application.secondaryports.mapper.commons.IdTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.commons.StatusEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.application.usecase.users.RegisterNewUser;
import co.inventory.system.ld.application.usecase.users.RegisterNewUserRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserImpl implements RegisterNewUser {

    private final UserRepository userRepository;
    private final RegisterNewUserRulesValidator registerNewUserRulesValidator;

    public RegisterNewUserImpl(UserRepository userRepository, RegisterNewUserRulesValidator registerNewUserRulesValidator) {
        this.userRepository = userRepository;
        this.registerNewUserRulesValidator = registerNewUserRulesValidator;
    }

    @Override
    public void execute(UserDomain domain) {
        registerNewUserRulesValidator.validate(domain);

        var userEntity = UserEntity.create().setId(domain.getId()).setName(domain.getName()).setLastName(domain.getLastName())
                .setIdType(IdTypeEntityMapper.INSTANCE.toEntity(domain.getIdType()))
                .setIdNumber(domain.getIdNumber()).setEmail(domain.getEmail())
                .setUserType(UserTypeEntityMapper.INSTANCE.toEntity(domain.getUserType()))
                .setStatus(StatusEntityMapper.INSTANCE.toEntity(domain.getStatus()))
                .setPassword(domain.getPassword());

        userRepository.save(userEntity);
    }
}
