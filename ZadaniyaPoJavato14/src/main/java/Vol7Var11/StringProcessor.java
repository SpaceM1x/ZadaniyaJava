package Vol7Var11;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.BiFunction;

public class StringProcessor {
    public static String processString(String input, int n, int m, int l) {

        BiFunction<String, Integer, String> process = (str, limit) -> Arrays.stream(str.split(" "))
                .limit(limit) // Ограничиваю количество слов
                .map(word -> word + ",") // Добавляю запятые
                .collect(Collectors.joining()); // Соединяюрезультат

        String repeatedString = process.apply(input, m).repeat(n); // Делаем N копий
        return repeatedString.length() > l ? repeatedString.substring(0, l) : repeatedString; // Ограничиваем длину
    }
}
