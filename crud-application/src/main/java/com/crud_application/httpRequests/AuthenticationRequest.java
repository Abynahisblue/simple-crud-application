package com.crud_application.httpRequests;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String username;
    private String password;
    private String role;
}
