import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator= calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println(currency.format(calculator.calculateMortgage()));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        System.out.println();
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
