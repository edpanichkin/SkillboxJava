public class Main {
    public static void main(String[] args) {
        CreditBankAccount cA = new CreditBankAccount(0.0,"Кредитный");
        cA.putCashCount(1000.0);
        //cA.printCashCount();
        cA.getCashOut(8000.0);

        cA.putCashCount(123.0);
        cA.printCashCount();

        DebetBankAccount dA = new DebetBankAccount(0.0, "Расчетный");
        dA.putCashCount(10.0);
        dA.getCashOut(8000.0);
    }
}
