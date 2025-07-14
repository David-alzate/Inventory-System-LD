package co.inventory.system.ld.application.usecase.users.impl;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.application.secondaryports.mapper.users.UserEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.application.usecase.users.GetLoggedInUserInfo;
import co.inventory.system.ld.domain.users.UserDomain;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetLoggedInUserInfoImpl implements GetLoggedInUserInfo {

    private final UserRepository userRepository;

    public GetLoggedInUserInfoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDomain execute() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        var user = UserEntity.create().setEmail(email);
        var userEntity = userRepository.findByFilter(user).get(0);

        return UserEntityMapper.INSTANCE.toDomain(userEntity);

    }
}
