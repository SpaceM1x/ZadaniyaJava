package Vol9Var11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/Vol9Var11/Numbers.txt";

        try {
            List<Double> numbers = NumberProcessor.readNumbersFromFile(filePath);

            // Расчет суммы и среднего
            double sum = NumberProcessor.calculateSum(numbers);
            double average = NumberProcessor.calculateAverage(numbers);

            System.out.println("Numbers: " + numbers);
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        } catch (InvalidNumberException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Runtime Error: " + e.getMessage());
        }
    }
}
