/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexpsitos
 */
public class GoFishTest {
    
    public GoFishTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getScore method, of class GoFish.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        GoFish instance = new GoFish();
        int expResult = instance.updateUserScore();
        int result = instance.updateUserScore();
       // assertEquals(expResult, result);
    }

    /**
     * Test of getCompHand method, of class GoFish.
     */
    @Test
    public void testGetCompHand() {
        System.out.println("getCompHand");
        GoFish instance = new GoFish();
        ArrayList<Card> expResult = instance.getCompHand();
        ArrayList<Card> result = instance.getCompHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserHand method, of class GoFish.
     */
    @Test
    public void testGetUserHand() {
        System.out.println("getUserHand");
        GoFish instance = new GoFish();
        ArrayList<Card> expResult = instance.getUserHand();
        ArrayList<Card> result = instance.getUserHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeck method, of class GoFish.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        GoFish instance = new GoFish();
        Deck expResult = instance.getDeck();
        Deck result = instance.getDeck();
        assertEquals(expResult, result);
    }
   
    /**
     * Test of updateScore method, of class GoFish.
     */
    /*
    @Test
    public void testUpdateScore() {
        System.out.println("updateScore");
        GoFish instance = new GoFish();
        int expResult = instance.updateScore();
        int result = instance.updateScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   */
}
