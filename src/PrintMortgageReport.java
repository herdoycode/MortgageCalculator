import java.text.NumberFormat;

public class PrintMortgageReport {
    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public PrintMortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println(currency.format(calculator.calculateMortgage()));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
