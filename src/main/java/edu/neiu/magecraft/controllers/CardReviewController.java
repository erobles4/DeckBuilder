package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.models.CardReview;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cardReview")
public class CardReviewController {

    @GetMapping
    public String addCardReview(Model model){
        model.addAttribute("cardReview", new CardReview());
        return "add-cardReview";
    }

    @PostMapping
    public String handleCardReviewForm(@ModelAttribute("cardReview") CardReview cardReview){
        System.out.println("Player Name " + cardReview.getPlayerName());
        System.out.println("Card Name " + cardReview.getCardName());
        System.out.println("Pros:" + cardReview.getPros());
        System.out.println("Cons:" + cardReview.getCons());
        return "redirect:/";
    }
}
