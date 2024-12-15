package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.domain.users.exceptions.user.UserIdDoesExistsException;
import co.inventory.system.ld.domain.users.rules.user.UserIdDoesNotExistsRule;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserIdDoesNotExistsRuleImpl implements UserIdDoesNotExistsRule {

    private final UserRepository userRepository;

    public UserIdDoesNotExistsRuleImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UUID data) {
        if (userRepository.existsById(data)) {
            throw UserIdDoesExistsException.create();
        }
    }
}
