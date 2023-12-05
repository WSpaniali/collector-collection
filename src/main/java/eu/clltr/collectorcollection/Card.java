package eu.clltr.collectorcollection;

import java.util.ArrayList;

public class Card {
    private String cardName;
    private String picture;
    // lista słów kluczowych na karcie - później ułatwi wyszukiwanie i konstruowanie talii
    // zamiast String to z ENUM niech bierze?
    private ArrayList<String> keywords;


    public Card(String cardName, String picture, ArrayList<String> keywords) {
        this.cardName = cardName;
        this.picture = picture;
        this.keywords = keywords;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
}
