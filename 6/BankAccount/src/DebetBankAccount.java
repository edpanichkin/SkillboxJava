import java.time.LocalDate;

public class DebetBankAccount extends BankAccount {
    LocalDate dateLastIncome;

    public DebetBankAccount(double startCash, String name) {
        super(startCash, name);
    }

    public void putCashCount(Double cash) {
        super.putCashCount(cash);
         dateLastIncome = LocalDate.now();
    }

    public boolean checkDate () {
        LocalDate chechNow = LocalDate.now();
        return  (dateLastIncome.getMonthValue() < chechNow.getMonthValue()
                && dateLastIncome.getYear() <= chechNow.getYear());
    }

    @Override
    public void getCashOut(double cash) {
        if (checkDate()) {
            super.getCashOut(cash);
        }
        else {
            System.out.println("\nРано снимать, деньги были внесены в: "
                    + dateLastIncome.getMonth());
        }

    }
}
