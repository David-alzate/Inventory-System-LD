package co.inventory.system.ld.domain.users.exceptions.user;

import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;

public class UserPasswordLenghtIsNotValidException extends RuleInventorySystemException {

    public UserPasswordLenghtIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static UserPasswordLenghtIsNotValidException create(){
        var userMessage =  "Password must be at least 8 characters";
        return new UserPasswordLenghtIsNotValidException(userMessage);
    }
}
