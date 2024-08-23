package com.crud_application.httpRequests;

import com.crud_application.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private UserResponse user;
    private String token;

    public LoginResponse() {

    }
    public LoginResponse(User user, String token) {
        this.user = new UserResponse(user.getId(), user.getUsername(), user.getRole().name());;
        this.token = token;
    }

}
