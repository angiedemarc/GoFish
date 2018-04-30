
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

    private int userScore;
    private int compScore;
    private ArrayList<Card> compHand = new ArrayList();
    private ArrayList<Card> userHand = new ArrayList();
    private Deck deck;
    private boolean userTurn; //might delete later

    public GoFish() {
        this.userScore = 0;
        this.compScore = 0;
        int numPlayers = 2;
        int numStartingCards = 7;
        Card[][] cardsDealt;
        do {
            this.deck = new Deck();
            deck.shuffle();
            cardsDealt = deck.dealHands(numPlayers, numStartingCards);
        } while (!checkAllForBooks(cardsDealt));
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
        View view = new View(this);
    }

    public boolean isGameOver() {
        if (userScore + compScore == 13) {
            return true;
        }
        return false;
    }

    //returns the symbol the computer is asking for
    public String compTurn() {
        if (!compHand.isEmpty()) {
            int rand = (int) (Math.random() * compHand.size());
            return compHand.get(rand).getSymbol();
        } else if (!userHand.isEmpty()){
            int rand = (int) (Math.random() * userHand.size());
            return userHand.get(rand).getSymbol();
        }
        else{
            return "endGame";
        }
    }

    //will be called when user clicks button 'go fish' or when it is computer's turn
    //parameter is the symbol the player asked for
    //returns 'true' if there were no matches
    public boolean noMatchGoFish(String symbol) {
        //System.out.println("UPDATE: \n user: " + userHand + " \ncomp:  " + compHand);
        boolean noMatches = true; //'lied' will be true if they actually did have a card with that symbol
        ArrayList<Card> playerAsking; //player asking for any cards with 'symbol'
        ArrayList<Card> playerGiving; //player who is checking to see if they have any cards with 'symbol' in their hand
        if (userTurn) {
            playerAsking = userHand;
            playerGiving = compHand;
        } else {
            playerAsking = compHand;
            playerGiving = userHand;
        }
        for (int i = 0; i < playerGiving.size(); i++) {
            if (playerGiving.get(i).getSymbol().equals(symbol)) { //USER WILL NEED TO BE ALERTED THEY DO HAVE A MATCH
                //if (userTurn){ not sure if this would work...wanted to make it be user would HAVE to say correctly 'go fish' or 'give card'
                giveCard(i);
                i--; //this way you check value 'i' again, since 'i' now holds new card
                //}
                noMatches = false;
            }
        }
        if (noMatches && !userTurn) {
            drawCard();
            userTurn = !userTurn;
        }
        return noMatches;
    }

    public boolean giveCard(int index) {
        if (userTurn) {
            userHand.add(compHand.get(index));
            compHand.remove(index);
            checkUserBooks();
            checkCompBooks();
            return false; //doesn't really matter because not used
        } else {
            String symbol = userHand.get(index).getSymbol();
            compHand.add(userHand.get(index));
            userHand.remove(index);
            checkCompBooks();
            return giveMorePoss(symbol);
        }
        
    }

    public boolean giveMorePoss(String symbol) {
        for (Card c : userHand) {
            if (c.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    

//a match of 4 is called a book
//compares last element added to hand
    public boolean checkUserBooks() {
        boolean foundFour = false;
        int count = 0;
        for (int i = 0; i < userHand.size(); i++) {
            if (userHand.get(i).compareTo(userHand.get(userHand.size() - 1)) == 0) {
                count++;
                if (count == 4) {
                    System.out.println("\n YOU SCORED A POINT!" + userHand.get(userHand.size()-1).getSymbol() + "\n");
                    foundFour = true;
                    updateUserScore();
                    removeFromHand(userHand, userHand.get(i).getSymbol());
                }
            }
        }

        return foundFour;
    }

    public boolean checkCompBooks() {
        boolean foundFour = false;
        int count = 0;

        for (int i = 0; i < compHand.size(); i++) {
            if (compHand.get(i).compareTo(compHand.get(compHand.size() - 1)) == 0) {
                count++;
                if (count == 4) {
                    System.out.println("\n COMPUTER SCORED A POINT!" + compHand.get(compHand.size()-1).getSymbol() + "\n");
                    foundFour = true;
                    updateCompScore();
                    removeFromHand(compHand, compHand.get(i).getSymbol());
                }
            }
        }

        return foundFour;
    }

    //method specific to goFish
    //returns 'true' if book found
    public boolean checkAllForBooks(Card[][] hands) {
        boolean bookFound = false;
        String symbol;
        int count1 = 0;
        int count2 = 0;
        for (int i = 2; i <= 14; i++) {
            if (i <= 10) {
                symbol = Integer.toString(i);
            } else if (i == 11) {
                symbol = "J";
            } else if (i == 12) {
                symbol = "Q";
            } else if (i == 13) {
                symbol = "K";
            } else {
                symbol = "A";
            }
            for (int j = 0; j < hands[0].length; j++) {
                if (hands[0][j].getSymbol().equals(symbol)) {
                    count1++;
                }
                if (hands[1][j].getSymbol().equals(symbol)) {
                    count2++;
                }
            }
            if (count1 == 4 || count2 == 4) {
                bookFound = true;
                int length1 = hands.length;
                int length2 = hands[0].length;
                for (int outer = 0; outer < length1; outer++) {
                    for (int inner = 0; inner < length2; inner++) {
                    }
                }
            }
        }
        return bookFound;
    }

    //had to use an iterator since you can't dynamically remove elements from arraylists
    public ArrayList<Card> removeFromHand(ArrayList<Card> hand, String symbol) {
        Iterator<Card> itr = hand.iterator();
        while (itr.hasNext()) {
            Card c = itr.next();
            if (c.getSymbol().equals(symbol)) {
                itr.remove();
            }
        }
        return hand;
    }

    //returns true if game is over
    public boolean checkEmptyHandsAndEndGame() {
        if (userHand.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                drawCard(userHand);
            }
        }
        if (compHand.isEmpty()){
            for (int i = 0; i < 5; i++) {
                drawCard(compHand);
            }
        }
        if (userHand.isEmpty() && compHand.isEmpty()){
            return true;
        }
        return false;
    }

    public void drawCard() {
        if (!deck.isEmpty()) {
            if (userTurn) {
                userHand.add(deck.getNextCard());
                checkUserBooks();
                userTurn = false;
            } else {
                compHand.add(deck.getNextCard());
                checkCompBooks();
            }
        }
    }
    
    public void drawCard(ArrayList hand) {
        if (!deck.isEmpty()) {
            hand.add(deck.getNextCard());
            checkUserBooks();
            checkCompBooks();
        }
    }

    public int updateUserScore() {
        this.userScore += 1;
        return this.userScore;
    }

    public int updateCompScore() {
        this.compScore += 1;
        return this.compScore;
    }

    //getters
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

    public int getUserHandSize() {
        return userHand.size();
    }

    public Deck getDeck() {
        return deck;
    }

    public boolean getUserTurn() {
        return userTurn;
    }

    //setters
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

}
