import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome To The Number Guessing Game!!!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Remaining attempts: " + (maxAttempts - attempts));
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in "
                        + attempts + " attempts.");
                score++;
            } else {
                System.out.println("Sorry, you couldn't guess the number. It was " + targetNumber + ".");
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing the Number Guessing Game!");
    }
}
