
package com.jose.newlibrary.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.newlibrary.library.model.entity.Author;

/**
 * AuthorRepository
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByNameIgnoreCase(String name);
}
