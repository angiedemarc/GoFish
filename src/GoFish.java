
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

    public GoFish() {
        this.score = 0;
        this.deck = new Deck();
        int numPlayers = 2;
        int numStartingCards = 7;
        Card[][] cardsDealt = deck.dealHands(numPlayers, numStartingCards);
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < numStartingCards; j++) {
                if (i==0){
                    compHand.add(cardsDealt[i][j]);
                }
                else{
                    userHand.add(cardsDealt[i][j]);
                }
            }
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
