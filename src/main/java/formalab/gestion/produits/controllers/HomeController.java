package formalab.gestion.produits.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello at Formalab";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloWithName(@PathVariable String name) {
        return "Hello "+name+" at Formalab";
    }

    @PostMapping("/goodbye")
    public String sayGoodBye() {
        return "Good bye";
    }

}
