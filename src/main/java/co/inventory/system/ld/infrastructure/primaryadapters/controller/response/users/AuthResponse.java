package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users;

import java.util.ArrayList;
import java.util.List;

public class AuthResponse {

    private String token;
    private String role;
    private List<String> messages;

    public AuthResponse() {
        this.messages = new ArrayList<>();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public List<String> getMessages() {
        return messages;
    }
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
