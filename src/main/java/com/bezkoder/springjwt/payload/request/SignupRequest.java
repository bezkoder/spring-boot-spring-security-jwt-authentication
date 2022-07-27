package com.bezkoder.springjwt.payload.request;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Value
public class SignupRequest {

    @Size(min = 3, max = 20)
    String username;

    @Size(max = 50)
    @Email
    String email;

    Set<String> roles;

    @Size(min = 6, max = 40)
    String password;

}
