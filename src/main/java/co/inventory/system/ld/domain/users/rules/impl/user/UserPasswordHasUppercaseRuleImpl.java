package co.inventory.system.ld.domain.users.rules.impl.user;

import co.inventory.system.ld.domain.users.exceptions.user.UserPasswordHasNotUppercaseException;
import co.inventory.system.ld.domain.users.rules.user.UserPasswordHasUppercaseRule;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserPasswordHasUppercaseRuleImpl implements UserPasswordHasUppercaseRule {
    private static final Pattern UPPERCASE_PATTERN =Pattern.compile(".*[A-Z].*");

    public boolean isVaLid(String password){
        return password != null && UPPERCASE_PATTERN.matcher(password).matches();
    }

    @Override
    public void validate(String data) {
        if (!isVaLid(data)) {
            throw UserPasswordHasNotUppercaseException.create();
        }
    }
}
