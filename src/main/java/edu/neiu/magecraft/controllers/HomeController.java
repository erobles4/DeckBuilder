package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.models.CardReview;
import edu.neiu.magecraft.models.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        return "index-page";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}
