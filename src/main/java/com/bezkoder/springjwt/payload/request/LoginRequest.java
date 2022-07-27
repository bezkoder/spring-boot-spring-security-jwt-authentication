package com.bezkoder.springjwt.payload.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class LoginRequest {
    @NotBlank
    String username;

    @NotBlank
    String password;

}
