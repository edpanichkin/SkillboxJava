public class CreditBankAccount extends BankAccount {
    public int percentage = 1;

    public CreditBankAccount(double startCash, String name) {
        super(startCash, name);
    }

    @Override
    public void getCashOut(double cash) {
        Double commision = (cash * percentage) / 100;
        super.getCashOut(cash + commision);
        System.out.printf("-- Комисия %.2f", commision);
    }
}
