import java.util.Scanner;

public class shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String item;
        double price;
        int amount;
        

        System.out.print("What item would you like to buy?: ");
        item = scanner.nextLine();
        System.out.print("What is the price of each item?: ");
        price = scanner.nextDouble();
        System.out.print("How many would you like to buy?: ");
        amount = scanner.nextInt();
        double total = amount * price;

        System.out.println("You have bought " + amount + " " + item + "/s");
        System.out.println("Your total is #" + total);

        scanner.close();
    }
}
