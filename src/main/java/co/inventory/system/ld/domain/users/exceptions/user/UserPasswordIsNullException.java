package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserPasswordIsNullException extends RuleInventorySystemException {

    private UserPasswordIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserPasswordIsNullException create(){
        var userMessage = "Password can't be null";
        return new UserPasswordIsNullException(userMessage);
    }
}
