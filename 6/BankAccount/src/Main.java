public class Main {
    public static void main(String[] args) {
        CreditBankAccount cA = new CreditBankAccount(0,"Кредитный");
        cA.putCashCount(1000);
        DebetBankAccount dA = new DebetBankAccount(0, "Расчетный");
        dA.putCashCount(10);
        dA.getCashOut(8000);
    }
}
