package Vol6Var11;

import java.util.Currency;

public class Main {
    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount(
                "Продолжительный",  // Продолжительность вклада
                "Отзывной",  // Тип вклада
                1000.0,       // Сумма вклада
                5.0,          // Процентная ставка
                Currency.getInstance("USD")  // Валюта вклада
        );

        account.displayInfo();

        account.changeDuration("Кратковременный");
        System.out.println("\nПосле изменения продолжительности:");
        account.displayInfo();

        System.out.println("\nТип депозита: " + account.getDepositType());

        // Расчет и вывод начисленных процентов
        double interest = account.calculateInterest();
        System.out.println("\nРассчитанный процент: " + interest);

        // Закрытие текущего вклада и открытие нового в другой валюте
        account.closeAndReopen("EUR");
        account.displayInfo();
    }
}
