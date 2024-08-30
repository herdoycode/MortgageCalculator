
public class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;
    private final int principal;
    private final float annualInterest;
    private final int years;

    MortgageCalculator(int principal, float annualInterest, int years){
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public  double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= getNumberOfPayments(); month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private float getMonthlyInterest() {
        byte PERCENT = 100;
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}
