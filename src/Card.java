
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angie
 */
public class Card implements Comparable <Card>{
    private String suit;
    private String symbol;

    public Card(){
        suit = "";
        symbol = "";
    }
    
    public Card(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Suit: " + this.suit + ", Symbol: " + this.symbol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Card otherCard) {
       int compareVal = symbol.compareTo(otherCard.symbol);
       return compareVal;
    }
}
