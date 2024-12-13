package Vol6Var11;

public interface BankDeposit {
    void changeDuration(String duration); // Изменение продолжительности вклада
    String getDepositType(); // Получение типа вклада (отзывной или безотзывной)
    void closeAndReopen(String newCurrency); // Закрытие вклада и открытие нового
    double calculateInterest(); // Расчет начисления процентов
}
