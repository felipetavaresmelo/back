package com.xproject.master.app.entrypoint;

import com.xproject.master.domain.entity.User;
import com.xproject.master.domain.usecase.UserRegisterUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    public UserRegisterUseCaseImpl useCase;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById (@PathVariable String userId) {
        return null;//ResponseEntity.ok();
    }
}
