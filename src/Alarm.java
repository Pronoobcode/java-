import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Alarm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath = "sun.wav";

        while(alarmTime == null){
            try {
            System.out.print("\nEnter an alarm time (HH:mm:ss): ");
            String inputTime = scanner.nextLine(); 

            alarmTime = LocalTime.parse(inputTime, formatter);
            System.out.println("Alarm set for " + alarmTime);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format, Please use Hours:Minutes:Seconds(HH:MM:SS)");
        }
        }

        Alarmclock alarmclock = new Alarmclock(alarmTime, filepath, scanner);
        Thread alThread = new Thread(alarmclock);
        alThread.start();

        
    }
}
