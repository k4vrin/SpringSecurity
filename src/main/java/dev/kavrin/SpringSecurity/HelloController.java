package dev.kavrin.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(HttpServletRequest request) {
        return "Hello World with Spring Security! session id: " + request.getSession().getId();
    }
}
