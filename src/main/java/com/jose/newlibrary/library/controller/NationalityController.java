
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

import com.jose.newlibrary.library.model.dto.request.NationalityRequest;
import com.jose.newlibrary.library.model.dto.response.NationalityResponse;
import com.jose.newlibrary.library.service.impl.NationalityServiceImpl;

import jakarta.validation.Valid;

/**
 * NationalityController
 */
@RestController
@RequestMapping("/nationalities")
public class NationalityController {

    private final NationalityServiceImpl nationalityService;

    public NationalityController(NationalityServiceImpl nationalityServiceImpl){
        this.nationalityService = nationalityServiceImpl;
    }

    @PostMapping
    public ResponseEntity<NationalityResponse> createNationality(@Valid @RequestBody NationalityRequest nationalityRequest){
        NationalityResponse nationalityResponse = nationalityService.createNationality(nationalityRequest);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(nationalityResponse.id())
            .toUri();
        return ResponseEntity.created(location).body(nationalityResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NationalityResponse> getNationality(@PathVariable Long id){
        NationalityResponse nationalityResponse = nationalityService.getNationality(id);
        return ResponseEntity.ok(nationalityResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NationalityResponse> updateNationality(@PathVariable Long id, @Valid @RequestBody NationalityRequest nationalityRequest){
        NationalityResponse nationalityResponse = nationalityService.updateNationality(id, nationalityRequest);
        return ResponseEntity.ok(nationalityResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteNationality(@PathVariable Long id){
        nationalityService.deleteNationality(id);
        Map<String, String> body = new HashMap<>();
        body.put("status", "ok");
        return ResponseEntity.ok(body);
    }
    
}
