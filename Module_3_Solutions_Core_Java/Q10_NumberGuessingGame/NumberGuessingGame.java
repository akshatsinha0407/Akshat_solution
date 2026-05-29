import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int secret = new Random().nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;
        System.out.println("Guess a number between 1 and 100:");
        do {
            guess = sc.nextInt();
            if (guess < secret) System.out.println("Too low! Try again:");
            else if (guess > secret) System.out.println("Too high! Try again:");
            else System.out.println("Correct! The number was " + secret);
        } while (guess != secret);
    }
}
