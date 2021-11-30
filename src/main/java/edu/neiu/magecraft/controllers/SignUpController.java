package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.data.UserRepository;
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

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserRepository userRepo;

    @Autowired
    public SignUpController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public String signUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/newSignUp")
    public String handleSignUpForm(@Valid @ModelAttribute("user") User user, Errors errors) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
