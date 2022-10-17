package com.nelson.demo.repository;

import com.nelson.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
}
