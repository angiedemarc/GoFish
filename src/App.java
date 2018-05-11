
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angie
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GoFish goFish = new GoFish();
        Scanner keyboard = new Scanner(System.in);
        String response;
        String compAsk;
        //was testing to see if noMatchGoFish worked (it does)
//        System.out.println("COMPUTER'S HAND" + goFish.getCompHand());
//        System.out.println("USER'S HAND" + goFish.getUserHand());
//        System.out.println("");
//        System.out.println(goFish.noMatchGoFish(goFish.getUserHand().get(0).getSymbol()));
//        System.out.println(goFish.noMatchGoFish(goFish.getUserHand().get(0).getSymbol()));
//        
//        System.out.println("COMPUTER'S HAND" + goFish.getCompHand());
//        System.out.println("USER'S HAND" + goFish.getUserHand());



        //allows you to play 'go fish' without GUI
//        while (!goFish.getDeck().isEmpty()) {
//            while (goFish.getUserTurn()) {
//                System.out.println("Your hand: " + goFish.getUserHand());
//                //System.out.println("Computer hand: " + goFish.getCompHand());
//                System.out.println("What symbol would you like to ask for?");
//                if (!goFish.noMatchGoFish(keyboard.nextLine())){
//                    System.out.println("The computer had that card! It's been added to your hand");
//                }
//                else{
//                    System.out.println("Go fish!");
//                }
//            }
//            while (!goFish.getUserTurn()) {
//                System.out.println("Your hand: " + goFish.getUserHand());
//                System.out.println("Computer hand: " + goFish.getCompHand());
//                compAsk = goFish.compTurn();
//                System.out.println("Do you have any " + compAsk);
//                response = keyboard.nextLine();
//                if (!goFish.noMatchGoFish(compAsk) && response.toLowerCase().contains("go fish")) {
//                    System.out.println("Actually, you had a " + compAsk + " and it was given to the computer");
//                }
//            }
//        }
    }

}
