import java.util.Scanner;

public class quiz {
    public static void main(String[] args) {
        String[] questions = {"What programming language is primarily used for web development?", 
        "Which company is known for its electric vehicles and solar products?", 
        "What technology is commonly used for secure data transmission over the internet?", 
        "Which framework is popular for building mobile applications?", 
        "What term describes the practice of protecting computers and networks from digital attacks?", 
        "Which of the following is a popular open-source database management system?", 
        "What is the primary function of an operating system?"};

        String[][] options = {{"a. Python", "b. JavaScript", "c. C++", "d. Ruby"},
        {"a. Ford", "b. Tesla", "c. General Motors", "d. Nissan"},
        {"a. HTTP", "b. FTP", "c. VPN", "d. SMTP"},
        {"a. Django", "b. React Native", "c. Flask", "d. Spring"},
        {"a. Data Analysis", "b. Cybersecurity", "c. Cloud Computing", "d. Machine Learning"},
        {"a. Oracle", "b. SQL Server", "c. MySQL", "d. MongoDB"},
        {"a. To compile code", "b. To manage hardware and software resources", "c. To provide internet access", "d. To create applications"}};

        String[] answers = {"b", "b", "c", "b", "b","c","b"};
        int score = 0;
        String guess;

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("******************************");
        System.out.println("Welcome to the java quiz game!");
        System.out.println("******************************");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for(String option : options[i]){
                System.out.println(option);
            }
            System.out.println();

            System.out.print("Enter your guess: ");
            guess = scanner.nextLine();
            System.out.println();

            if (guess.equals(answers[i])) {
                System.out.println("********");
                System.out.println("Correct!");
                System.out.println("********");
                score++;
            } else {
                System.out.println("******");
                System.out.println("Wrong!");
                System.out.println("******");
            }


        }
        System.out.println("Your final score is: "+ score + " out of " + questions.length);


        scanner.close();
    }
}
