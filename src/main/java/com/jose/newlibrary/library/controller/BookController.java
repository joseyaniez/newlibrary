
package com.jose.newlibrary.library.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jose.newlibrary.library.model.dto.request.BookRequest;
import com.jose.newlibrary.library.model.dto.response.BookResponse;
import com.jose.newlibrary.library.service.impl.BookServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * BookController
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookServiceImpl){
        this.bookService = bookServiceImpl;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest bookRequest){
        BookResponse bookResponse = bookService.createBook(bookRequest);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(bookResponse.id())
            .toUri();
        return ResponseEntity.created(location).body(bookResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id){
        BookResponse book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/title")
    public ResponseEntity<List<BookResponse>> getBooksByTitle(@RequestParam String title){
        List<BookResponse> books = bookService.getBookByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookResponse>> getBooksByAuthorId(@PathVariable Long authorId){
        List<BookResponse> books = bookService.getBooksByAuthor(authorId);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    public Page<BookResponse> getAllBooks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDir
    ){
        Sort sort = sortDir.equalsIgnoreCase("asc")
            ? Sort.by(sortBy).ascending()
            : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return bookService.getAllBooks(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest){
        BookResponse book = bookService.updateBook(id, bookRequest);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        Map<String, String> body = new HashMap<>();
        body.put("status", "ok");
        return ResponseEntity.ok(body);
    }

}
