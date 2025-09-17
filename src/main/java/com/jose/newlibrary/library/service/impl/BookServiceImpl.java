
package com.jose.newlibrary.library.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jose.newlibrary.core.exception.exceptions.ResourceNotFoundException;
import com.jose.newlibrary.library.model.dto.request.BookRequest;
import com.jose.newlibrary.library.model.dto.response.BookResponse;
import com.jose.newlibrary.library.model.entity.Author;
import com.jose.newlibrary.library.model.entity.Book;
import com.jose.newlibrary.library.repository.AuthorRepository;
import com.jose.newlibrary.library.repository.BookRepository;
import com.jose.newlibrary.library.service.BookService;

/**
 * BookServiceImpl
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

	@Override
	public BookResponse createBook(BookRequest bookRequest) {
        Author author = authorRepository.findById(bookRequest.authorId())
            .orElseThrow(() -> new IllegalArgumentException("No existe un author con id = " + bookRequest.authorId()));
        if(bookRepository.existsByTitleAndAuthorId(bookRequest.title(), bookRequest.authorId())){
            throw new IllegalArgumentException("Ya existe un libro con este título para este autor");
        }
        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setPublicationDate(bookRequest.publicationDate());
        book.setAuthor(author);
        bookRepository.save(book);
        return new BookResponse(
            book.getId(),
            book.getTitle(),
            book.getPublicationDate(),
            book.getAuthor().getName()
        );
	}

	@Override
	public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontró el libro con id = " + id));
        return new BookResponse(
            book.getId(),
            book.getTitle(),
            book.getPublicationDate(),
            book.getAuthor().getName()
        );
	}

	@Override
	public List<BookResponse> getBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream().map(book -> new BookResponse(
            book.getId(),
            book.getTitle(),
            book.getPublicationDate(),
            book.getAuthor().getName()
        )).toList();
	}

	@Override
	public List<BookResponse> getBooksByAuthor(Long authorId) {
        if(!authorRepository.existsById(authorId)){
            throw new ResourceNotFoundException("El autor con id " + authorId + " no existe");
        }
        List<Book> books = bookRepository.findByAuthorId(authorId);
        return books.stream()
            .map( book -> new BookResponse(book.getId(), book.getTitle(), book.getPublicationDate(), null))
            .toList();
	}

	@Override
	public Page<BookResponse> getAllBooks(Pageable pageable) {
        return bookRepository
            .findAll(pageable)
            .map(book -> new BookResponse(book.getId(), book.getTitle(), book.getPublicationDate(), book.getAuthor().getName()));
	}

	@Override
	public BookResponse updateBook(Long id, BookRequest bookRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
	}

    
}
