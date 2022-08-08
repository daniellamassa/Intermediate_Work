package proj3;

/**
 * @author: Dani Massa
 *
 * 'I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.'
 */

import java.util.Scanner;
public class Client {

    public static void main(String[] args) {

        Deck deck = new Deck();
        int points = 0;
        PokerHand hand1;
        PokerHand hand2;
        boolean gameOver = false;

        deck.shuffle();
        while (! gameOver){
            hand1 = new PokerHand(deck.deal(5));
            hand2 = new PokerHand(deck.deal(5));
            System.out.println("Hand 1: " + hand1);
            System.out.println("Hand 2: " + hand2);
            Scanner userInput = new Scanner(System.in);
            System.out.println("Which hand wins?\nInput 1 for Hand 1.\nInput -1 for Hand 2.\nInput 0 if it's a tie.");
            int userAnswer = Integer.parseInt(userInput.nextLine());
            int correctAnswer = hand1.compareTo(hand2);
            if (userAnswer == correctAnswer){
                System.out.println("Correct!");
                points ++;
            } else{
                System.out.println("Sorry! The correct answer was: " + correctAnswer + "\nGame Over. Total points: " + points);
                gameOver = true;
            } if (deck.size() < 5){
                System.out.println("Not enough cards remain! Total points: " + points);
                gameOver = true;
            }
        }

    }

}
