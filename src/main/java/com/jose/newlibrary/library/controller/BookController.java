
package com.jose.newlibrary.library.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jose.newlibrary.library.controller.requestbody.BookRequestTitle;
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

}
