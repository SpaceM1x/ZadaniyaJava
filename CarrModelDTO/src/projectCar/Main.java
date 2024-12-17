package projectCar;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            // Создание сервиса и загрузка данных
            CarService carService = new CarService("JavaCars.txt");

            //  Получение уникальных брендов
            System.out.println("Уникальные бренды автомобилей:");
            Set<String> uniqueBrands = carService.getUniqueBrands();
            uniqueBrands.forEach(System.out::println);

            //  Получение моделей по бренду
            String brandToFilter = "Toyota";
            System.out.println("\nМодели бренда " + brandToFilter + ":");
            List<String> modelsByBrand = carService.getModelsByBrand(brandToFilter);
            modelsByBrand.forEach(System.out::println);

            //  Группировка по бренду
            System.out.println("\nКоличество моделей по брендам:");
            Map<String, Integer> brandCounts = carService.groupByBrand();
            brandCounts.forEach((brand, count) -> System.out.println(brand + ": " + count));

            //  Генерация автомобилей и добавление их в дилерский центр
            DealerCenter dealerCenter = new DealerCenter("AutoWorld");
            List<CarDTO> cars = carService.generateCars(dealerCenter, 5);
            System.out.println("\nСгенерированные автомобили:");
            cars.forEach(System.out::println);

            System.out.println("\nАвтомобили в дилерском центре:");
            System.out.println(dealerCenter);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
