package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserPasswordHasNotANumberException extends RuleInventorySystemException {

    public UserPasswordHasNotANumberException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserPasswordHasNotANumberException create(){
        var userMessage = "Password must have a number";
        return new UserPasswordHasNotANumberException(userMessage);
    }
}
