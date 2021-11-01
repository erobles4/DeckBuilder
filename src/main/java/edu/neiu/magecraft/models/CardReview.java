package edu.neiu.magecraft.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class CardReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Player name is required")
    @Size(min = 2, message = "Player name must be 2 or more characters")
    private String playerName;
    @NotBlank(message = "Card name is required")
    @Size(min = 2, message = "Card name must be 2 or more characters")
    private String cardName;
    @NotNull(message = "Have you played with the card yet")
    private String pros;
    @NotNull(message = "Have you played with the card yet")
    private String cons;


    private LocalDateTime created;
    private LocalDateTime modified;

    public CardReview(){
        this.playerName = "";
        this.cardName = "";
        this.pros = "";
        this.cons = "";
    }

    public CardReview(String playerName, String cardName, String pros, String cons){
        this.playerName = playerName;
        this.cardName = cardName;
        this.pros = pros;
        this.cons = cons;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    @PrePersist
    public void onCreate(){
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate(){
        this.setModified(LocalDateTime.now());
    }

}
