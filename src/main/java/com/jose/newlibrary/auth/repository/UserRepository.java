
package com.jose.newlibrary.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.newlibrary.auth.model.entity.UserEntity;


/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    
}
