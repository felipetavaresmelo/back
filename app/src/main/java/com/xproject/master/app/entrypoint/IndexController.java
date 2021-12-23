package com.xproject.master.app.entrypoint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
