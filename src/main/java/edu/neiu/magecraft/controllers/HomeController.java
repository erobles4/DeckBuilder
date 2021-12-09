package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.data.CardReviewRepository;
import edu.neiu.magecraft.data.UserRepository;
import edu.neiu.magecraft.models.CardReview;
import edu.neiu.magecraft.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserRepository userRepo;

    @Autowired
    public HomeController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getHomePage(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        return "index-page";
    }

    @GetMapping("/users")
    public String showUser(Model model){
        List<User> user = (List<User>) this.userRepo.findAll();
        model.addAttribute("user", user);
        return "display-users";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        this.userRepo.deleteById(id);
        return "redirect:/display-users";
    }

}
