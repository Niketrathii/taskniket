import java.util.Random;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int minRange = 1;
        int maxRange = 10;
        int maxAttempts = 10; 
        int roundsPlayed = 0;
        int totalScore = 0;
        do {
            int generatedNumber = ra.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            System.out.println("Round " + (roundsPlayed + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ":");
            while (attempts < maxAttempts) {
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.nextInt();
                }
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("low, Try again.");
                } else {
                    System.out.println("high,Try again.");
                }
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of chances. The correct number was: " + generatedNumber);
                }
            }
            roundsPlayed++;
            System.out.println("Do you want to play again? (1 for yes, 0 for no):");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        } while (sc.nextInt() == 1);
        System.out.println("Game Over. Rounds played: " + roundsPlayed + " | Total Score: " + totalScore);
        sc.close();
    }
}