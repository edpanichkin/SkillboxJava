import java.time.LocalDate;

public class BankAccount {
    private float cashCount;
    private String nameAccount;

    public BankAccount (float startCash, String name) {
        this.nameAccount = name;
        this.cashCount = startCash;
    }

    public void printCashCount() {
        System.out.printf("На счете %s хранится %.2f%n", nameAccount, cashCount);
    }

    public void putCashCount(float cash) {
        System.out.printf("На счет %s внесли средства %.2f, теперь остаток %.2f%n",
                nameAccount, cash, (this.cashCount += cash));
    }

    public void getCashOut(float cash) {
        if(withdraw(cash)) {
            cashCount -= cash;
            System.out.printf("Выведено %.2f, Остаток %.2f %n", cash, cashCount);
        }
        else {
            System.out.printf(" !! Недостаточно средств для вывода, попытка снять %.2f, на счету %.2f%n",
                    cash, cashCount);
        }
    }
    public boolean withdraw(float cash) {
        return cashCount >= cash;
}
}
