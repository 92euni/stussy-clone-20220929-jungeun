package com.stussy.stussyclone20220929jungeun.dto.account;

import lombok.Data;

@Data
public class RegisterReqDto {

    private String lastName;
    private String firstName;
    private String email;
    private String password;
}
