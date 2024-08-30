
public class MortgageCalculator {
    private final byte MONTH_IN_YEAR = 12;
    private final byte PERCENT = 100;
    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years){
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterest / MONTH_IN_YEAR / PERCENT;
        int numberOfPayments = years * MONTH_IN_YEAR;
        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateBalance(int month) {
        float monthlyInterest = annualInterest / MONTH_IN_YEAR / PERCENT;
        int numberOfPayments = years * MONTH_IN_YEAR;
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, month))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTH_IN_YEAR;
    }
}
