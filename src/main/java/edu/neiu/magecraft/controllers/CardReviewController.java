package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.data.CardReviewRepository;
import edu.neiu.magecraft.models.CardReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/cardReview")
public class CardReviewController {

    private CardReviewRepository cardReviewRepo;

    @Autowired
    public CardReviewController(CardReviewRepository cardReviewRepo){
        this.cardReviewRepo = cardReviewRepo;
    }

    @GetMapping
    public String addCardReview(Model model){
        model.addAttribute("cardReview", new CardReview());
        return "add-cardReview";
    }

    @PostMapping
    public String handleCardReviewForm(@Valid @ModelAttribute("cardReview") CardReview cardReview, Errors errors){
        if(errors.hasErrors())
            return "add-cardReview";

        this.cardReviewRepo.save(cardReview);
        return "redirect:/view";
    }
}
