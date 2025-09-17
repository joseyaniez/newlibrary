
package com.jose.newlibrary.library.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jose.newlibrary.library.model.dto.request.BookRequest;
import com.jose.newlibrary.library.model.dto.response.BookResponse;

/**
 * BookService
 */
public interface BookService {
    BookResponse createBook(BookRequest bookRequest);
    BookResponse getBookById(Long id);
    List<BookResponse> getBookByTitle(String title);
    List<BookResponse> getBooksByAuthor(Long authorId);
    Page<BookResponse> getAllBooks(Pageable pageable);
    BookResponse updateBook(Long id, BookRequest bookRequest);
    void deleteBook(Long id);
}
