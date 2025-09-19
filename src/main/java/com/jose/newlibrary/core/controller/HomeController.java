
package com.jose.newlibrary.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Hola a todos";
    }
    
}
