package Vol7Var11;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.BiFunction;

public class StringProcessor {
    public static String processString(String input, int n, int m, int l) {

        // Лямбда выражение для обработки строки
        BiFunction<String, Integer, String> process = (str, limit) -> Arrays.stream(str.split(" "))
                .limit(limit) // Ограничиваем количество слов
                .map(word -> word + ",") // Добавляем запятые
                .collect(Collectors.joining()); // Соединяем результат

        String repeatedString = process.apply(input, m).repeat(n); // Делаем N копий
        return repeatedString.length() > l ? repeatedString.substring(0, l) : repeatedString; // Ограничиваем длину
    }
}
