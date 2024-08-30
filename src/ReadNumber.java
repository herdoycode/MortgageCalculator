import java.util.Scanner;

public class ReadNumber {
    public static double readNumber(String prompt, int min, int max) {
        var scanner = new Scanner(System.in);
        double value;

        do {
            System.out.print(prompt);
            value = scanner.nextDouble();
        } while (min > value || max < value);

        return value;
    }
}
