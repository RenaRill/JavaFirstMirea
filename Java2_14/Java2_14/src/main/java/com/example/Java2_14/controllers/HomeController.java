package com.example.Java2_14.controllers;

import com.example.Java2_14.models.User;
import com.example.Java2_14.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder ;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/myLogin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView registration() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String registration(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/myLogin";
    }

    @PostMapping("/myLogin")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return "home";
        }
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/home";
        } else {
            return "redirect:/myLogin";
        }
    }
}
