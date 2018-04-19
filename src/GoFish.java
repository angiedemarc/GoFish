
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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

    int userScore;
    int compScore;
    ArrayList<Card> compHand = new ArrayList();
    ArrayList<Card> userHand = new ArrayList();
    Deck deck;
    boolean userTurn; //might delete later

    public GoFish() {
        this.userScore = 0;
        this.compScore = 0;
        View view = new View(this);
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
        userTurn = !userTurn;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getCompScore() {
        return compScore;
    }

    public boolean isUserTurn() {
        return userTurn;
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

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void setCompScore(int compScore) {
        this.compScore = compScore;
    }

    public void setUserTurn(boolean userTurn) {
        this.userTurn = userTurn;
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
   
//a match of 4 is called a book
    public boolean checkUserBooks(){
        boolean foundFour = false;
        int count = 0; 
        for(int i = 0; i < userHand.size()-1; i++){
            for(int j = i + 1; j < userHand.size(); j++){
                if(userHand.get(i).compareTo(userHand.get(j)) == 0){
                    count++;
//did a simpler test with integers using this layout and it didn't work properly with 4 but it did with 3
                    if(count == 3 || count % 3 == 0){
                        System.out.println("You've got a book! You earned one point.");
                        updateUserScore();
                        removeFromHand(userHand, userHand.get(i).getSymbol());
                        foundFour = true;
                    }
                }
            }
            count = 0;
        }
        
        return foundFour;
    }
    
    public boolean checkCompBooks(){
        boolean foundFour = false;
        int count = 0;
       
        for(int i = 0; i < compHand.size()-1; i++){
            for(int j = i+1; j < compHand.size(); j++){
                if(compHand.get(i).compareTo(userHand.get(j)) == 0){
                    count++;
                    if(count == 3 || count % 3 == 0){
                        foundFour = true;
                        updateCompScore();
                        removeFromHand(compHand, compHand.get(i).getSymbol());
                    }
                }
            }
            count = 0;
        }
        
        return foundFour;
    }
    
    //had to use an iterator since you can't dynamically remove elements from arraylists
    public ArrayList<Card> removeFromHand(ArrayList<Card> hand, String symbol){
        Iterator<Card> itr = hand.iterator();
         while(itr.hasNext()){
             Card c = itr.next();
             if(c.getSymbol().equals(symbol)){
                itr.remove();
            }
         }
        return hand;
    }
   
    public int updateUserScore(){
      this.userScore += 1;
      return this.userScore;
    }  
    
     public int updateCompScore(){
      this.compScore += 1;
      return this.compScore;
    }  

}
