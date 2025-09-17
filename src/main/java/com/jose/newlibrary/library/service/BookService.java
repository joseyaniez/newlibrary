
package com.jose.newlibrary.library.service;

import java.util.List;

import com.jose.newlibrary.library.model.dto.request.BookRequest;
import com.jose.newlibrary.library.model.dto.response.BookResponse;

/**
 * BookService
 */
public interface BookService {
    BookResponse createBook(BookRequest bookRequest);
    BookResponse getBookById(Long id);
    List<BookResponse> getBookByName(String name);
    List<BookResponse> getBooksByAuthor(Long authorId);
    List<BookResponse> getAllBooks();
    BookResponse updateBook(Long id, BookRequest bookRequest);
    void deleteBook(Long id);
}
