package edu.neiu.magecraft.controllers;


import edu.neiu.magecraft.data.CardReviewRepository;
import edu.neiu.magecraft.models.CardReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewCardReviewsController {

    private CardReviewRepository cardReviewRepo;

    @Autowired
    public ViewCardReviewsController(CardReviewRepository cardReviewRepo){
        this.cardReviewRepo = cardReviewRepo;
    }

    @GetMapping
    public String showCardReview(Model model){
        List<CardReview> cardReviews = (List<CardReview>) this.cardReviewRepo.findAll();
        model.addAttribute("cardReview", cardReviews);
        return "display-cardReviews";
    }
}
