import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Hangman {
    public static void main(String[] args) {
        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (words.isEmpty()) {
            System.out.println("No words found in the file!");
            return;
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size())).toLowerCase();
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        HashSet<Character> guessedLetters = new HashSet<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("***********************");
        System.out.println("Welcome to Java Hangman");
        System.out.println("***********************");

        while (wrongGuesses < 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            
            System.out.println("\nGuessed letters: " + guessedLetters);
            
            char guess;
            do {
                System.out.print("Guess a letter: ");
                String input = scanner.next().toLowerCase();
                guess = input.isEmpty() ? ' ' : input.charAt(0);
                
                if (guessedLetters.contains(guess)) {
                    System.out.println("You've already guessed that letter!");
                }
            } while (guessedLetters.contains(guess));
            
            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!\n");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
                
                if (!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("You win!");
                    System.out.println("The word was: " + word);
                    scanner.close();
                    return;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess!\n");
            }
        }

        System.out.println(getHangmanArt(6));
        System.out.println("Game over!");
        System.out.println("The word was: " + word);
        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                    
                    
                    
                    
                    """;
            case 1 -> """
                    0
                    
                    
                    
                    """;
            case 2 -> """
                    0
                    |
                    
                    
                    """;
            case 3 -> """
                    0
                   /|
                    
                    
                    """;
            case 4 -> """
                    0
                   /|\\
                    
                    
                    """;
            case 5 -> """
                    0
                   /|\\
                   / 
                    
                    """;
            case 6 -> """
                    0
                   /|\\
                   / \\
                    
                    """;
            default -> "";
        };
    }
}
