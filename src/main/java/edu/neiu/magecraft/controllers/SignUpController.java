package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.data.UserRepository;
import edu.neiu.magecraft.models.CardReview;
import edu.neiu.magecraft.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserRepository userRepo;

    @Autowired
    public SignUpController(UserRepository userRepo){
        this.userRepo = userRepo;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping
    public String signUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping
    public String handleSignUpForm(@Valid @ModelAttribute("user") User user, BCryptPasswordEncoder passwordEncoder,Errors errors) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        if(errors.hasErrors())
            return "signup";

        try {
            this.userRepo.save(user);
        } catch(DataIntegrityViolationException e){
            errors.rejectValue("email", "invalidEmail", "Email not available");
            return "signup";
        }

        return "index-page";
    }
}
