
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
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    
    public Deck(){

        for (int i = 0; i<52; i++){
            deck.add(new Card());
            //sets the suit -- 4 options
            if (i%4 == 0){
                deck.get(i).setSuit("tuna");
            }
            else if (i%4 == 1){
                deck.get(i).setSuit("salmon");
            }
            else if (i%4 == 2){
                deck.get(i).setSuit("goldfish");
            }
            else{
                deck.get(i).setSuit("angelfish");
            }
            //sets the symbol -- 13 options
            int j = 52/13;
            if (i < j){
                deck.get(i).setSymbol("A");
            }
            else if (i< 2*j){
                deck.get(i).setSymbol("2");
            }
            else if (i< 3*j){
                deck.get(i).setSymbol("3");
            }
            else if (i< 4*j){
                deck.get(i).setSymbol("4");
            }
            else if (i< 5*j){
                deck.get(i).setSymbol("5");
            }
            else if (i< 6*j){
                deck.get(i).setSymbol("6");
            }
            else if (i< 7*j){
                deck.get(i).setSymbol("7");
            }
            else if (i< 8*j){
                deck.get(i).setSymbol("8");
            }
            else if (i< 9*j){
                deck.get(i).setSymbol("9");
            }
            else if (i< 10*j){
                deck.get(i).setSymbol("10");
            }
            else if (i< 11*j){
                deck.get(i).setSymbol("J");
            }
            else if (i< 12*j){
                deck.get(i).setSymbol("Q");
            }
            else{
                deck.get(i).setSymbol("K");
            }
        }
    }
    
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<>();
        int randInt;
        for (int i = 0; i<52; i++){
            randInt = (int) (Math.random()*(deck.size()));
            shuffled.add(deck.get(randInt));
            deck.remove(randInt);
        }
        deck = shuffled;
    }
    
    //returns 2 hands of 7 cards each in a 2d array
    //returns an array but I think the hands should be arraylists in the 'gofish' class so cards can easily be added/removed and can have more than 7 cards in hand at a time
    public Card[][] dealHands(){
        Card[][] hands = new Card[2][7];
        for (int i = 0; i<2; i++){
            for (int j = 0; j<7; j++){
                hands[i][j] = deck.get(deck.size()-1);
                deck.remove(deck.size()-1);
            }
        }
        return hands;
    }
    
    public Card getNextCard(){
        Card nextCard = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return nextCard;
    }
    
    public void printDeck(){
        for (int i = 0; i<deck.size(); i++){
            System.out.println(deck.get(i).toString());
        }
    }
    
}
