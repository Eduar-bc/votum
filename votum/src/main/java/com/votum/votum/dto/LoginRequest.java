package com.votum.votum.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}