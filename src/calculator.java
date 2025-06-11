import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // double firstNum, secondNum;
        // String operator;

        // System.out.print("Enter the first number: ");
        // firstNum = scanner.nextDouble();

        // System.out.print("Pick an operator (+, -, /, *): ");
        // operator = scanner.next();
        
        // System.out.print("Enter a second number: ");
        // secondNum = scanner.nextDouble();

        // switch (operator) {
        //     case "+" -> System.out.println(firstNum + secondNum);
        //     case "-" -> System.out.println(firstNum - secondNum);
        //     case "/" -> System.out.println(firstNum / secondNum);
        //     case "*" -> System.out.println(firstNum * secondNum);
        //     default -> System.out.println("Pick a valid operator");
        // }

        double num1, num2, result = 0;
        char operator;
        boolean validoperation = true;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Pick an operator (+, -, /, *, ^): ");
        operator = scanner.next().charAt(0);

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("cannot divide by zero");
                    validoperation = false;
                } else {
                    result = num1 / num2;
                }
            }
            case '^' -> result = Math.pow(num1, num2);
            default -> {
                System.out.println("Pick a valid operator");
                validoperation = false;
            }
        }

        if (validoperation) {
            System.out.println(result);
        }
        

        scanner.close();

    }
}
