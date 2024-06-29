package fast.campus.fcss12.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/v1/hello")
    public String getHello() {
        return "GET /api/v1/hello";
    }

    @PostMapping("/api/v1/hello")
    public String postHello() {
        return "POST /api/v1/hello";
    }
}
