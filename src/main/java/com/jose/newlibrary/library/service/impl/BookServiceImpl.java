
package com.jose.newlibrary.library.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
	}

	@Override
	public List<BookResponse> getBookByName(String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBookByName'");
	}

	@Override
	public List<BookResponse> getBooksByAuthor(Long authorId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBooksByAuthor'");
	}

	@Override
	public List<BookResponse> getAllBooks() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllBooks'");
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
