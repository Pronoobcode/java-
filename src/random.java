import java.util.Random;

public class random {
    public static void main(String[] args){
        Random random = new Random();

        int number;
        number = random.nextInt(1, 7);
        System.out.println(number);

        boolean isHeads;
        isHeads = random.nextBoolean();
        System.out.println(isHeads);
    }
}
