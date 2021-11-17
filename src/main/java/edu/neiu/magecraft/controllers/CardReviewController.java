package edu.neiu.magecraft.controllers;

import edu.neiu.magecraft.data.CardReviewRepository;
import edu.neiu.magecraft.models.CardReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/view/{id}")
    public String showCardView(@PathVariable Long id, Model model){
        CardReview cardReview = this.cardReviewRepo.findById(id).get();
        model.addAttribute("cardReview", cardReview);
        return"view-cardReview";
    }

    @PostMapping
    public String handleCardReviewForm(@Valid @ModelAttribute("cardReview") CardReview cardReview, Errors errors){
        if(errors.hasErrors())
            return "add-cardReview";

        try {
            this.cardReviewRepo.save(cardReview);
        } catch(DataIntegrityViolationException e){
            errors.rejectValue("email", "invalidEmail", "Email not available");
            return "add-cardReview";
        }

        return "redirect:/view";
    }

    @PostMapping("/edit/{id}")
    public String handleEditsCardReviewForm(@PathVariable Long id, @Valid @ModelAttribute("cardReview") CardReview cardReview, Errors errors){
        if(errors.hasErrors())
            return "view-cardReview";

        try {
            CardReview originalCardReview = this.cardReviewRepo.findById(id).get();
            updateOriginCardReview(originalCardReview, cardReview);
            this.cardReviewRepo.save(cardReview);
        } catch(DataIntegrityViolationException e){
            errors.rejectValue("email", "invalidEmail", "Email not available");
            return "view-cardReview";
        }

        return "redirect:/view";
    }

    private void updateOriginCardReview(CardReview original, CardReview update){
        original.setPlayerName(update.getPlayerName());
        original.setCardName(update.getCardName());
        original.setEmail(update.getEmail());
        original.setPros(update.getPros());
        original.setCons(update.getCons());
    }

    @GetMapping("/delete/{id}")
    public String deleteCardReview(@PathVariable Long id){
        this.cardReviewRepo.deleteById(id);
        return "redirect:/view";
    }
}
