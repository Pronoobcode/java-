import java.util.Scanner;

public class compound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A = p[1 + r/n]^(nt)

        double amount, principal, rate;
        int timesCompounded, numberYears;

        System.out.print("Enter the principal amount: ");
        principal = scanner.nextDouble();

        System.out.print("Enter the interest rate (%): ");
        rate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of times compounded per year: ");
        timesCompounded = scanner.nextInt();

        System.out.print("Enter the number of years: ");
        numberYears = scanner.nextInt();

        amount = principal * Math.pow((1 + (rate/timesCompounded)), (timesCompounded*numberYears));
        
        System.out.printf("The amount after %d is #%.2f", numberYears, amount);

        scanner.close();
    }
}
