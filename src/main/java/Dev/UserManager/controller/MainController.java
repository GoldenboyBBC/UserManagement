package dev.usermanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import dev.usermanager.service.UserService;
import dev.usermanager.model.User;
import java.util.Optional;

@Controller
public class MainController
{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final UserService u;

    public MainController(UserService u)
    {
        this.u = u;
    }

    @GetMapping("/")
    public String HomeURL(Model model)
    {
        model.addAttribute("users", u.getUsers());
        return "home";
    }

    @GetMapping("/register")
    public String RegisterURL()
    {
        return "register";
    }

    @GetMapping("/login")
    public String LoginURL()
    {
        return "login";
    }

    @GetMapping("/users")
    public String users()
    {
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model)
    {   
        Optional<User> found = u.register(username, password);
        
        if (found.isPresent())
        {
            model.addAttribute("error", String.format("\"%s\" already exists, please choose another one.", found.get().getUsername()));
            return "register";
        }

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model)
    {
        String error = u.LoginUser(username, password);

        if (error != null)
        {
            model.addAttribute("error", error);
            logger.warn("Login attempt failed for user: {}", username);
            return "login";
        }

        logger.info("Login attempt successful for user: {}", username);
        return "redirect:/";
    }
}
