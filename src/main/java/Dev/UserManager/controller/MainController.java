package Dev.UserManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import Dev.UserManager.service.UserService;
import Dev.UserManager.model.User;

@Controller
public class MainController
{
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
    public String users(Model model)
    {
        model.addAttribute("users", u.getUsers());

        return "users";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model)
    {   
        User found = u.register(username, password);
        
        if (found != null)
        {
            model.addAttribute("error", String.format("\"%s\" already exists, please choose another one.", found.getUsername()));
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
            System.out.println(String.format("Login attempt: User --> '%s' Password --> '%s' Status --> Failed", username, password));
            return "login";
        }

        System.out.println(String.format("Login attempt: User --> '%s' Password --> '%s' Status --> Success", username, password));
        return "redirect:/";
    }
}
