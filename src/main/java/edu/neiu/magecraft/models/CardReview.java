package edu.neiu.magecraft.models;

public class CardReview {
    private String playerName;
    private String cardName;
    private String pros;
    private String cons;

    public CardReview(){
        this.playerName = "";
        this.cardName = "";
        this.pros = "";
        this.cons = "";
    }

    public CardReview(String playName, String cardName, String pros, String cons){
        this.playerName = playName;
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
}
