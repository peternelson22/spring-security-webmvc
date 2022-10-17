package com.nelson.demo.service;

import com.nelson.demo.model.AppUser;
import com.nelson.demo.web.dto.AppUserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {

    AppUser save(AppUserRegistrationDto userRegistrationDto);
}
