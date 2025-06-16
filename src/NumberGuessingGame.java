import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberGuessingGame {

    public static void main(String[] args) {
        System.out.println("Welcome to the number guessing game!");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Do you want to play (Y/N): ");
            String response = scanner.nextLine().toUpperCase();

            if (response.equals("Y")) {
                guessNumber(scanner);
            } else {
                System.out.println("Thanks for playing!");
                break;
            }
        }
        scanner.close();
    }

    static void guessNumber(Scanner scanner) {
        String userName = "";
        while (true) {
            System.out.print("What is your username: ");
            userName = scanner.nextLine();

            if (userName.length() < 4 || Pattern.compile("[,.\\/ _]").matcher(userName).find()) {
                System.out.println("Write a valid user name of more than 4 characters without [',','.','/','_',' '].");
            } else {
                System.out.println("Valid username");
                break;
            }
        }

        System.out.println("Hello " + userName);

        int minNum = 0, maxNum = 0;
        while (true) {
            System.out.print("Pick a minimum value for the guessing game: ");
            String mini = scanner.nextLine();
            System.out.print("Pick a maximum value for the guessing game: ");
            String maxi = scanner.nextLine();

            try {
                minNum = Integer.parseInt(mini);
                maxNum = Integer.parseInt(maxi);
                if (minNum >= 0 && maxNum > minNum) {
                    break;
                } else {
                    System.out.println("Input must not be negative and max must be greater than min.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers.");
            }
        }

        Random random = new Random();
        int randomNumber = random.nextInt(maxNum - minNum + 1) + minNum;

        while (true) {
            System.out.printf("Enter a number between %d and %d: ", minNum, maxNum);
            String guessInput = scanner.nextLine();
            try {
                int guess = Integer.parseInt(guessInput);
                if (guess < minNum || guess > maxNum) {
                    System.out.printf("Enter a number within the range of %d-%d.%n", minNum, maxNum);
                } else if (guess > randomNumber) {
                    System.out.println("Too high");
                } else if (guess < randomNumber) {
                    System.out.println("Too low");
                } else {
                    System.out.println("You guessed the number!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
