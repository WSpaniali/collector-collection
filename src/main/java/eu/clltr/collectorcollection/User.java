package eu.clltr.collectorcollection;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    private String username;
    private String email;
    private Collection<Card> cards;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.cards = new ArrayList<>(); // Inicjalizacja pustej kolekcji kart
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Card> getCards() {
        return cards;
    }

    public void setCards(Collection<Card> cards) {
        this.cards = cards;
    }
}
