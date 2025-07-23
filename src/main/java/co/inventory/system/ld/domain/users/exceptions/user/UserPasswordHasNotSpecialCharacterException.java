package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserPasswordHasNotSpecialCharacterException extends RuleInventorySystemException {

    public UserPasswordHasNotSpecialCharacterException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserPasswordHasNotSpecialCharacterException create(){
        var userMessage = "Password must have at least one special character ";
        return new UserPasswordHasNotSpecialCharacterException(userMessage);
    }
}
