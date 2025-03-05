package com.example.Imp.Controller;

import com.example.Imp.Entity.User;
import com.example.Imp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Obtén el nombre del usuario autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // Busca en la base de datos
        Optional<User> userOpt = userService.findByUsername(username);
        if(userOpt.isPresent()){
            model.addAttribute("user", userOpt.get());
        } else {
            // Maneja el caso en que el usuario no se encuentre
            model.addAttribute("user", null);
        }

        return "home"; // Vista home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Vista login.html
    }
}