
package com.jose.newlibrary.library.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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

import com.jose.newlibrary.library.controller.requestbody.AuthorRequestName;
import com.jose.newlibrary.library.model.dto.request.AuthorRequest;
import com.jose.newlibrary.library.model.dto.response.AuthorResponse;
import com.jose.newlibrary.library.service.impl.AuthorServiceImpl;

import jakarta.validation.Valid;

/**
 * AuthorController
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorServiceImpl){
        this.authorService = authorServiceImpl;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest authorRequest){
        AuthorResponse author = authorService.createAuthor(authorRequest);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(author.Id())
            .toUri();
        return ResponseEntity.created(location).body(author);
    }

    @GetMapping("/name")
    public ResponseEntity<AuthorResponse> getAuthorByName(@RequestBody AuthorRequestName authorRequestName){
        AuthorResponse author = authorService.getAuthorByName(authorRequestName.name());
        return ResponseEntity.ok(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable Long id){
        AuthorResponse author = authorService.getAuthor(id);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorRequest authorRequest){
        AuthorResponse author = authorService.updateAuthor(id, authorRequest);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        Map<String, String> body = new HashMap<>();
        body.put("status", "ok");
        return ResponseEntity.ok(body);
    }
}
