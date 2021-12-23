package com.xproject.master.app.entrypoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductController {
    @GetMapping("/product/{id}")
    ResponseEntity<String> geProductById(@PathVariable String id);
}
