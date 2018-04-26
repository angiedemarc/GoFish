/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexpsitos
 */
public class DeckTest {

    public DeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

//    /**
//     * Test of shuffle method, of class Deck.
//     */
//    @Test
//    public void testShuffle() {
//        System.out.println("shuffle");
//        Deck instance = new Deck();
//        instance.shuffle();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of dealHands method, of class Deck.
     */
    private ArrayList<Card> deck = new ArrayList<>();
  
     

    @Test
    public void testDeckSize() {

        System.out.println("deckSize");

        int expResult = 52;

        for (int i = 0; i < 52; i++) {
            deck.add(new Card());

            //sets the suit -- 4 options
            switch (i % 4) {
                case 0:
                    deck.get(i).setSuit("tuna");
                    break;
                case 1:
                    deck.get(i).setSuit("salmon");
                    break;
                case 2:
                    deck.get(i).setSuit("goldfish");
                    break;
                default:
                    deck.get(i).setSuit("angelfish");
                    break;
            }
            //sets the symbol -- 13 options
            int j = 52 / 13;
            if (i < j) {
                deck.get(i).setSymbol("A");
            } else if (i < 2 * j) {
                deck.get(i).setSymbol("2");
            } else if (i < 3 * j) {
                deck.get(i).setSymbol("3");
            } else if (i < 4 * j) {
                deck.get(i).setSymbol("4");
            } else if (i < 5 * j) {
                deck.get(i).setSymbol("5");
            } else if (i < 6 * j) {
                deck.get(i).setSymbol("6");
            } else if (i < 7 * j) {
                deck.get(i).setSymbol("7");
            } else if (i < 8 * j) {
                deck.get(i).setSymbol("8");
            } else if (i < 9 * j) {
                deck.get(i).setSymbol("9");
            } else if (i < 10 * j) {
                deck.get(i).setSymbol("10");
            } else if (i < 11 * j) {
                deck.get(i).setSymbol("J");
            } else if (i < 12 * j) {
                deck.get(i).setSymbol("Q");
            } else {
                deck.get(i).setSymbol("K");
            }
        }

        assertEquals(expResult, deck.size());

    }
//  private HashSet<Card> setDeck = new HashSet<>();
//
//    @Test
//    public void testAllCards() {
//        System.out.println("allCardsInDeck");
//
//        for (int i = 0; i < 52; i++) {
//            deck.add(new Card());
//
//            //sets the suit -- 4 options
//            switch (i % 4) {
//                case 0:
//                    deck.get(i).setSuit("tuna");
//                    break;
//                case 1:
//                    deck.get(i).setSuit("salmon");
//                    break;
//                case 2:
//                    deck.get(i).setSuit("goldfish");
//                    break;
//                default:
//                    deck.get(i).setSuit("angelfish");
//                    break;
//            }
//            //sets the symbol -- 13 options
//            int j = 52 / 13;
//            if (i < j) {
//                deck.get(i).setSymbol("A");
//            } else if (i < 2 * j) {
//                deck.get(i).setSymbol("2");
//            } else if (i < 3 * j) {
//                deck.get(i).setSymbol("3");
//            } else if (i < 4 * j) {
//                deck.get(i).setSymbol("4");
//            } else if (i < 5 * j) {
//                deck.get(i).setSymbol("5");
//            } else if (i < 6 * j) {
//                deck.get(i).setSymbol("6");
//            } else if (i < 7 * j) {
//                deck.get(i).setSymbol("7");
//            } else if (i < 8 * j) {
//                deck.get(i).setSymbol("8");
//            } else if (i < 9 * j) {
//                deck.get(i).setSymbol("9");
//            } else if (i < 10 * j) {
//                deck.get(i).setSymbol("10");
//            } else if (i < 11 * j) {
//                deck.get(i).setSymbol("J");
//            } else if (i < 12 * j) {
//                deck.get(i).setSymbol("Q");
//            } else {
//                deck.get(i).setSymbol("K");
//            }
//           // setDeck.addAll(deck);
//        }
//
//        //setDeck.addAll(deck);
//        System.out.println(setDeck);
//        // System.out.println(deck);
//        assertEquals(52, setDeck.size());
//    }

    /**
     * Test of getNextCard method, of class Deck.
     */
    @Test
    public void testGetNextCard() {
        System.out.println("getNextCard");
        Deck instance = new Deck();
        Card expResult = instance.getNextCard();
        Card result = instance.getNextCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Deck instance = new Deck();
        boolean expResult = instance.isEmpty();
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

//    /**
//     * Test of printDeck method, of class Deck.
//     */
//    @Test
//    public void testPrintDeck() {
//        System.out.println("printDeck");
//        Deck instance = new Deck();
//        instance.printDeck();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
