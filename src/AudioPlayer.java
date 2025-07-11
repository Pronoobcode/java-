import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AudioPlayer {
    public static void main(String[] args) {
        String compressedPath = "C:\\Users\\USER\\Downloads\\compressed";
        File directory = new File(compressedPath);
        
        try {
            
            if (!directory.isDirectory()) {
                throw new FileNotFoundException();
            }
            
            
            File[] files = directory.listFiles((dir, name) -> 
                name.toLowerCase().endsWith(".wav") || 
                name.toLowerCase().endsWith(".au") || 
                name.toLowerCase().endsWith(".aiff"));
            
            if (files == null || files.length == 0) {
                System.out.println("No supported audio files found");
                return;
            }
            
            File audioFile = files[0];
            
            try (Scanner scanner = new Scanner(System.in);
                 AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
                
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                
                String response = "";
                while (!response.equals("Q")) {
                    System.out.println("\nP = Play | S = Stop | R = Reset | Q = Quit");
                    System.out.print("Enter choice: ");
                    response = scanner.next().toUpperCase();
                    
                    switch (response) {
                        case "P" -> clip.start();
                        case "S" -> clip.stop();
                        case "R" -> clip.setMicrosecondPosition(0);
                        case "Q" -> clip.close();
                        default -> System.out.println("Invalid choice");
                    }
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Directory not found");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio format");
        }
        catch (LineUnavailableException | IOException e) {
            System.out.println("Playback error");
        }
        finally {
            System.out.println("Goodbye!");
        }
    }
}
