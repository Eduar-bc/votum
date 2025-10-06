package com.votum.votum.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}
