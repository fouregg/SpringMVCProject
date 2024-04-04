package com.example.spring.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello") // В этом случае, мы указываем, что URL будет обязательно перед методами иметь /hello
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello_world";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "good_bye";
    }

    /*
    @GetMapping("/testParams")
    public String testParams(HttpServletRequest request) {
        String params1 = request.getParameter("name");
        return params1;
    }
    */
    @GetMapping("/testParams")
    public String testParams(@RequestParam("name") String name, @RequestParam("last_name") String lastName,
                             Model model){
        model.addAttribute("params1", name);
        model.addAttribute("params2", lastName);
        return "answer_params";
    }
}
