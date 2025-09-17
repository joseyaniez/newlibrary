
package com.jose.newlibrary.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.newlibrary.library.model.entity.Book;

/**
 * BookRepository
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
    List<Book> findByAuthorName(Long id);
    boolean existsByTitleAndAuthorId(String title, Long authorId);
    // ya trae el findall con pageable
}
