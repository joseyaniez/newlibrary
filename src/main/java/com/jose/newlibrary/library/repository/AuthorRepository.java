
package com.jose.newlibrary.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.newlibrary.library.model.entity.Author;

/**
 * AuthorRepository
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<Author> findByNameIgnoreCase(String name);
}
