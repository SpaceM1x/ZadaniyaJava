package Vol7Var11;

public class Main {
    public static void main(String[] args) {
        // Входные данные
        String input = "This is a test of the StringProcessor class";
        int n = 2; // Количество копий
        int m = 4; // Максимальное количество слов
        int l = 50; // Ограничение на длину строки

        // Вызов метода и вывод результата
        String result = StringProcessor.processString(input, n, m, l);

        System.out.println("Обработаннаая строка: " + result);

    }
}
