package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.domain.users.exceptions.user.UserPasswordHasNotANumberException;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordHasANumberRule;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserPasswordHasANumberRuleImpl implements UserPasswordHasANumberRule {

    private static final Pattern DIGIT_PATTERN = Pattern.compile(".*\\d.*");

    public boolean isValid(String password){
        return password != null && DIGIT_PATTERN.matcher(password).matches();
    }

    @Override
    public void validate(String data) {
        if (!isValid(data)){
            throw  UserPasswordHasNotANumberException.create();
        }
    }
}
