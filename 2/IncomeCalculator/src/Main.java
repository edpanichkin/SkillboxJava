import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100000;

    public static void main(String[] args)
    {
        // Расчет минимального значения суммы доходов для возможности инвестировать
        int minIncome = (int)Math.ceil((minInvestmentsAmount + (1 - mainTaxPercent) * calculateFixedCharges())
                /((1 - managerPercent) * (1 - mainTaxPercent)));
        System.out.println("///Минимальный доход для возможного инвестирования: "+minIncome + "\n");

        while(true)
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt();
            // проверка на вернность введенных данных
            if(!checkIncomeRange(income)) {
                continue;
            }

            double managerSalary = income * managerPercent; // расчет процентов зп менеджера от дохода
            double pureIncome = income - managerSalary -
                calculateFixedCharges(); //расчет прибыли до вычета налогов
            System.out.println("Постоянные расходы: " +calculateFixedCharges());
            double taxAmount = mainTaxPercent * pureIncome; // расчет налоговой нагрузки
            double pureIncomeAfterTax = pureIncome - taxAmount; // расчет прибыли после вычета налогов

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount; //остались ли деньги, можно ли инвестировать

            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }
    // функция проверки, верно ли ввели сумму дохода относительно заданных в программе условий
    private static boolean checkIncomeRange(int income)
    {
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }
    // суммирование постоянных (фиксированных) расходов
    private static int calculateFixedCharges()
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
