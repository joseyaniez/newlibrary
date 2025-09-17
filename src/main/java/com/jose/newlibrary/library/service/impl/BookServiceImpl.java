
package com.jose.newlibrary.library.service.impl;

import java.util.List;

import com.jose.newlibrary.library.model.dto.request.BookRequest;
import com.jose.newlibrary.library.model.dto.response.BookResponse;
import com.jose.newlibrary.library.service.BookService;

/**
 * BookServiceImpl
 */
public class BookServiceImpl implements BookService {

	@Override
	public BookResponse createBook(BookRequest bookRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createBook'");
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
