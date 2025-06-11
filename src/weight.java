import java.util.Scanner;
public class weight {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String response;
        double inweight;
        double outweigth;

        System.out.println("Weight Conversion Program");
        System.out.println("1: Convert lbs to kgs");
        System.out.println("2: Convert kgs to lbs");

        System.out.print("Choose an option (1 or 2): ");
        response = scanner.nextLine();

        if (response.contains("1")) {
            System.out.print("Enter the weigth in lbs: ");
            inweight = scanner.nextDouble();
            outweigth = inweight * 0.45359237;
            System.out.printf("The new weight in kgs is: %.2f", outweigth);
        } 
        else if (response.contains("2")){
            System.out.print("Enter the weigth in kgs: ");
            inweight = scanner.nextDouble();
            outweigth = inweight / 0.45359237;
            System.out.printf("The new weight in lbs is: %.2f", outweigth);
        }
        else {
            System.out.println("Please enter a valid option");
        }

        scanner.close();
    }
}
