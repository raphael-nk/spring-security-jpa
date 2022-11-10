package nk.dev.springsecurityjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping
    public String home(){
        return "Hello World";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome back User";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome back Admin";
    }
}
