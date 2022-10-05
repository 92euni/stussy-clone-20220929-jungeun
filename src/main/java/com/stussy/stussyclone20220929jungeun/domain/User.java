package com.stussy.stussyclone20220929jungeun.domain;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String oauth_username;
    private String password;
    private String name;
    private String email;
    private String provider;
    private int role_id;
    private Role role;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
