import java.util.Random;
import java.util.Scanner;

public class guessnum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1, max = 100, randomNumber = random.nextInt(min, max + 1), guess = 0;

        System.out.println("Welcome to number guessing game");
        System.out.printf("Guess a numbrt between %d-%d\n",min, max);

        while (guess != randomNumber ) {
            System.out.print("Enter a guess: ");
            guess = scanner.nextInt();

            if (guess < randomNumber) {
                System.out.println("Too low");
            }
            else{
                System.out.println("Too high");
            }
        }

        System.out.println("You guessed correctly");

        scanner.close();
    }
}
