import java.text.SimpleDateFormat;

public class DebetBankAccount extends BankAccount {
    private long monthLastIncome;
    SimpleDateFormat formatDate = new SimpleDateFormat("M");

    public DebetBankAccount(double startCash, String name) {
        super(startCash, name);
    }

    public void putCashCount(Double cash) {
        super.putCashCount(cash);
        monthLastIncome = System.currentTimeMillis();
    }

    public boolean checkDate () {
        int monthLeft = Integer.parseInt(formatDate.format(monthLastIncome));
        int monthRight = Integer.parseInt(formatDate.format(System.currentTimeMillis()));
        return  (monthLeft < monthRight);
    }
    @Override

    public void getCashOut(double cash) {
        if (checkDate()) {
            super.getCashOut(cash);
        }
        else {
            System.out.printf("\nРано снимать, деньги были внесены в: "
                    + formatDate.format(monthLastIncome) + " месяце");
        }

    }
}
