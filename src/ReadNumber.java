import java.util.Scanner;

public class ReadNumber {
    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        do {
            System.out.print(prompt);
            value = scanner.nextDouble();
        } while (value < min || value > max);
        return value;
    }
}
