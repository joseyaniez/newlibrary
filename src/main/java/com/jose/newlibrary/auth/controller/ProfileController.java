
package com.jose.newlibrary.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jose.newlibrary.auth.model.dto.ProfileRequest;
import com.jose.newlibrary.auth.model.dto.ProfileResponse;
import com.jose.newlibrary.auth.service.ProfileService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * ProfileController
 */
@RestController
//@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
        ProfileResponse response = profileService.createProfile(request);
        return response;
    }

    @GetMapping("/test")
    public String test(){
        return "OK!";
    }
    
}
