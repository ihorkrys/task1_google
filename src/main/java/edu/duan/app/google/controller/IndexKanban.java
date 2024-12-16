package edu.duan.app.google.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexKanban {
    @GetMapping("/hello")
    public String helloKanban() {
        return "index";
    }
}
