import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAXATTEMPTS = 10;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean play;

        do {
            play = false;
            int randomNumber = generateNumber(MIN, MAX);
            boolean guess = false;
            int attempts = 0;

            System.out.println("In this Game a Random Number betwween" + MIN + " and " + MAX + " has been generated.");
            System.out.println("You have " + MAXATTEMPTS + " attempts to guess the number.");

            while (!guess && attempts < MAXATTEMPTS) {
                System.out.print("Enter your number that you have guessed: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < MIN || userGuess > MAX) {
                    System.out.println("Please guess a number within the range of " + MIN + " to " + MAX + ".");
                    attempts--; // Do not count this attempt
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    guess = true;
                    System.out.println("Congratulations! You've guessed the right number: " + randomNumber);
                    score += (MAXATTEMPTS - attempts + 1); // Score based on remaining attempts
                    System.out.println("Your score for this round is: " + (MAXATTEMPTS - attempts + 1));
                }
            }

            if (!guess) {
                System.out.println("Game Over! You have used all your attempts. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play the game(yes/no)");
            String response = sc.next();
            if (response.equalsIgnoreCase("yes"))
                play= true;


        } while (play);

        System.out.println("Thank you for playing! Your total score is: " + score);
        sc.close();
    }

    private static int generateNumber(int min, int max) {
        Random R = new Random();
        return R.nextInt(max - min + 1) + min;
    }
}