public class BankAccount {
    private double cashCount;
    private String nameAccount;

    public BankAccount (double startCash, String name) {
        this.nameAccount = name;
        this.cashCount = startCash;
    }

    public void printCashCount() {
        System.out.printf("\nНа счете %s хранится %.2f", nameAccount, cashCount);
    }

    public void putCashCount(Double cash) {
        System.out.printf("\nНа счет %s внесли средства %.2f, теперь остаток %.2f",
                nameAccount, cash, (this.cashCount += cash));
    }

    public void getCashOut(double cash) {
        if(withdraw(cash)) {
            cashCount -= cash;
            System.out.printf("\nВыведено %.2f, Остаток %.2f ", cash, cashCount);
        }
        else {
            System.out.printf("\n !! Недостаточно средств для вывода, попытка снять %.2f, на счету %.2f",
                    cash, cashCount);
        }

    }
    public boolean withdraw(double cash) {
        return cashCount > cash;
}
}
