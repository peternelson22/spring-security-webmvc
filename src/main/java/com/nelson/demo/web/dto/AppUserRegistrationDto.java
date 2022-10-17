package com.nelson.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRegistrationDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}