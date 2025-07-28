package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserPasswordHasNotUppercaseException extends RuleInventorySystemException {

    public UserPasswordHasNotUppercaseException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserPasswordHasNotUppercaseException create(){
        var userMessage = "Password muts have at least one uppercase letter";
        return new UserPasswordHasNotUppercaseException(userMessage);
    }
}
