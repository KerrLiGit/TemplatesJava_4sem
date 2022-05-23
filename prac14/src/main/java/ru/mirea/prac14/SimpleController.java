package ru.mirea.prac14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
    @GetMapping("/home")
    public @ResponseBody
    String home() {
        return "<h1>Bogatyreva Anna, IKBO-10-20, 2</h1>";
    }
}