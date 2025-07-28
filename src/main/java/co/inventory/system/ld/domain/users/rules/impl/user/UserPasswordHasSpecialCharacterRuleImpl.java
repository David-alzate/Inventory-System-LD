package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.domain.users.exceptions.user.UserPasswordHasNotSpecialCharacterException;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordHasSpecialCharacterRule;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserPasswordHasSpecialCharacterRuleImpl implements UserPasswordHasSpecialCharacterRule {

    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile(".*[^a-zA-Z0-9].*");

    public boolean isValid(String password){
        return password != null && SPECIAL_CHARACTER_PATTERN.matcher(password).matches();
    }

    @Override
    public void validate(String data) {
        if (!isValid(data)){
            throw UserPasswordHasNotSpecialCharacterException.create();
        }
    }
}
