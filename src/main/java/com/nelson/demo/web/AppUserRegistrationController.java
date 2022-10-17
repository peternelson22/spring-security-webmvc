package com.nelson.demo.web;

import com.nelson.demo.service.AppUserService;
import com.nelson.demo.web.dto.AppUserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class AppUserRegistrationController {

    private AppUserService appUserService;

    @ModelAttribute("user")
    public AppUserRegistrationDto userRegistrationDto(){
        return new AppUserRegistrationDto();
    }

    @GetMapping
    public String displayRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") AppUserRegistrationDto userRegistrationDto){
        appUserService.save(userRegistrationDto);
        return "redirect:/app?success";
    }
}
