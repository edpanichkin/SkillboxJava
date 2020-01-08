import java.time.LocalDate;

public class DebetBankAccount extends BankAccount {
    LocalDate dateLastIncome;

    public DebetBankAccount(float startCash, String name) {
        super(startCash, name);
    }
    @Override
    public void putCashCount(float cash) {
        super.putCashCount(cash);
        dateLastIncome = LocalDate.now();
    }
    public boolean isMonthPassed () {
        return  dateLastIncome.isAfter(LocalDate.now().plusMonths(1));
    }
    @Override
    public void getCashOut(float cash) {
        if (isMonthPassed()) {
            super.getCashOut(cash);
            System.out.println("Вы успешно сняли свои средства в размере " + cash);
        }
        else {
            System.out.println("\nРано снимать, деньги были внесены в: "
                    + dateLastIncome);
        }
    }
}
