public class Main {
    public static void main(String[] args){
        int principal = (int) ReadNumber.readNumber("Principal: ", 1000, 1000000);
        float annualInterest = (float) ReadNumber.readNumber("Annual InterestRate: ", 1, 100);
        byte years = (byte) ReadNumber.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new PrintMortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();

    }

}