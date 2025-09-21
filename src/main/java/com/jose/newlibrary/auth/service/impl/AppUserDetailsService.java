
package com.jose.newlibrary.auth.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jose.newlibrary.auth.model.entity.UserEntity;
import com.jose.newlibrary.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * AppUserDetailsService
 */
@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existingUser = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("No existe un usuario con email " + email));
        return new User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
	}

    
}
