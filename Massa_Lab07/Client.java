import java.util.Scanner;
public class Client {

    private static int TWELVE_DIE = 12;
    private static int SIX_DIE = 6;
    private static int MULTIPLE = 2;

    public static void main(String[] args) {
        Die sixDie;
        Die twelveDie;
        boolean gameOver;

        sixDie = new Die();
        twelveDie = new Die(TWELVE_DIE);
        gameOver = false;
        Scanner returnKey = new Scanner(System.in);
        System.out.println("Press the 'return' key to begin.");
        returnKey.nextLine();
        while (! gameOver) {
            sixDie.roll();
            twelveDie.roll();
            System.out.println(sixDie);
            System.out.println(twelveDie);
            int die1Val = sixDie.getValue();
            int die2Val = twelveDie.getValue();
            if (die1Val == MULTIPLE * die2Val || die2Val == MULTIPLE * die1Val) {
                gameOver = true;
                System.out.println("Game Won!");

            }
            else {
                System.out.println("Press the 'return' key to continue.");
                returnKey.nextLine();
            }
        }


    }
}
