package com.xproject.master.app.entrypoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClientController {
    ResponseEntity<String> getUserById(@PathVariable String id);
}
