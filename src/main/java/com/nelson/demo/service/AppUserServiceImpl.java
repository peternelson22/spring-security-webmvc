package com.nelson.demo.service;

import com.nelson.demo.model.AppUser;
import com.nelson.demo.model.Role;
import com.nelson.demo.repository.AppUserRepository;
import com.nelson.demo.web.dto.AppUserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService{

    private AppUserRepository appUserRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public AppUser save(AppUserRegistrationDto userRegistrationDto) {

        AppUser user = new AppUser(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), passwordEncoder.encode(userRegistrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER")));

        return appUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = appUserRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new User(user.getEmail(), user.getPassword(), )

        return null;
    }

    private Collection<<? extends <SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
()
    }
}
