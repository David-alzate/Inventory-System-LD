package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserPasswordIsEmptyException extends RuleInventorySystemException {

    private UserPasswordIsEmptyException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserPasswordIsEmptyException create(){
        var userMessage = "Password can't be empty";
        return new UserPasswordIsEmptyException(userMessage);
    }
}
