public class Main {
    public static void main(String[] args) {
        int principal = (int) ReadNumber.readNumber("Principal: ", 1000, 1000000);
        float annualInterest = (float) ReadNumber.readNumber("Annual Interest: ", 1, 100);
        byte years = (byte) ReadNumber.readNumber("Period (Years): ", 1, 30);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
        MortgageReport report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}