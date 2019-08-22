package hello.controllers;

import hello.model.Name;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NameRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping("/name")
    public Name greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Name(counter.incrementAndGet(),
                String.format(template, name));
    }
}
