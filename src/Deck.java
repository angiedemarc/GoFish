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
    
    public Deck(){
        Card [] deck = new Card[52];
        for (int i = 0; i<deck.length; i++){
            //sets the suit -- 4 options
            if (i%4 == 0){
                deck[i].setSuit("tuna");
            }
            else if (i%4 == 1){
                deck[i].setSuit("salmon");
            }
            else if (i%4 == 2){
                deck[i].setSuit("goldfish");
            }
            else{
                deck[i].setSuit("angelfish");
            }
            //sets the symbol -- 13 options
            if (i%13 == 0){
                deck[i].setSymbol("A");
            }
            else if (i%13 == 1){
                deck[i].setSymbol("2");
            }
            else if (i%13 == 2){
                deck[i].setSymbol("3");
            }
            else if (i%13 == 3){
                deck[i].setSymbol("4");
            }
            else if (i%13 == 4){
                deck[i].setSymbol("5");
            }
            else if (i%13 == 5){
                deck[i].setSymbol("6");
            }
            else if (i%13 == 6){
                deck[i].setSymbol("7");
            }
            else if (i%13 == 7){
                deck[i].setSymbol("8");
            }
            else if (i%13 == 8){
                deck[i].setSymbol("9");
            }
            else if (i%13 == 9){
                deck[i].setSymbol("10");
            }
            else if (i%13 == 10){
                deck[i].setSymbol("J");
            }
            else if (i%13 == 11){
                deck[i].setSymbol("Q");
            }
            else{
                deck[i].setSymbol("K");
            }
        }
    }
    
}
