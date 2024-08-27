package com.crud_application.httpRequests;

import com.crud_application.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String role;

    public UserResponse() {

    }
    public UserResponse(String username, String role) {
        this.username = username;
        this.role = role;
    }


    public UserResponse(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.role = Role.USER.toString();
    }
}
