public class CreditBankAccount extends BankAccount {
    public static final int PERCENTAGE = 1;

    public CreditBankAccount(float startCash, String name) {
        super(startCash, name);
    }

    @Override
    public void getCashOut(float cash) {
        float commision = (cash * PERCENTAGE) / 100;
        super.getCashOut(cash + commision);
        System.out.printf("-- Комисия %.2f%n", commision);
    }
}
