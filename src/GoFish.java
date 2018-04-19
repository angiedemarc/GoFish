
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angie
 */
public class GoFish {

    int score;
    ArrayList<Card> compHand = new ArrayList();
    ArrayList<Card> userHand = new ArrayList();
    Deck deck;
    boolean userTurn; //might delete later

    public GoFish() {
        this.score = 0;
        this.deck = new Deck();
        int numPlayers = 2;
        int numStartingCards = 7;
        Card[][] cardsDealt = deck.dealHands(numPlayers, numStartingCards);
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < numStartingCards; j++) {
                if (i == 0) {
                    compHand.add(cardsDealt[i][j]);
                } else {
                    userHand.add(cardsDealt[i][j]);
                }
            }
        }
        userTurn = true; //starts as user's turn - might delete later
    }

    //will be called when user clicks button 'go fish'
    //parameter is the symbol the computer asked for
    public void noMatchGoFish(String symbol) {
        boolean lied = false; //'lied' will be true if they actually did have a card with that symbol
        for (int i = 0; i < userHand.size(); i++) {
            if (userHand.get(i).getSymbol().equals(symbol)) {
                System.out.println("You lied!! You are going to give them this card");
                //code to give the computer the card they asked for
                compHand.add(userHand.get(i));
                userHand.remove(i);
                lied = true;
            }
        }
        if (!lied) {
            if (!deck.isEmpty()) {
                compHand.add(deck.getNextCard());
            }
        }
        if (userTurn){
            userTurn = false;
        }
        else{
            userTurn = true;
        }
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getCompHand() {
        return compHand;
    }

    public ArrayList<Card> getUserHand() {
        return userHand;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCompHand(ArrayList<Card> compHand) {
        this.compHand = compHand;
    }

    public void setUserHand(ArrayList<Card> userHand) {
        this.userHand = userHand;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int updateScore() {
        return 0;
    }

}
