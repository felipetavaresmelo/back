package com.xproject.master.app.entrypoint.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductController {
    ResponseEntity<String> geProductById(@PathVariable String id);
}
