/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angie
 */
public class Card {
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
    
    
}
