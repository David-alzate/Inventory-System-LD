package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.domain.customers.exceptions.CustomerEmailFormatIsNotValidException;
import co.inventory.system.ld.domain.customers.rules.CustomerEmailFormatIsValidRule;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CustomerEmailFormatIsValidRuleImpl implements CustomerEmailFormatIsValidRule {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    @Override
    public void validate(String data) {
        if (!EMAIL_PATTERN.matcher(data).matches()) {
            throw CustomerEmailFormatIsNotValidException.create();
        }
    }
}
