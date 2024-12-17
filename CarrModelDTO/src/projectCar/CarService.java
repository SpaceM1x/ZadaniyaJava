package projectCar;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService {

    private List<CarModelDTO> carModels;
    private Random random; // поле random

    // Конструктор, инициализируем поле random
    public CarService(String filePath) throws IOException {
        this.carModels = CarModelDTO.loadFromFile(filePath);
        this.random = new Random(); // Инициализация поля random
    }

    public Set<String> getUniqueBrands() {
        Set<String> uniqueBrands = new HashSet<>();
        for (CarModelDTO carModel : carModels) {
            uniqueBrands.add(carModel.getBrand());
        }
        return uniqueBrands;
    }

    public List<String> getModelsByBrand(String brand) {
        List<String> models = new ArrayList<>();
        for (CarModelDTO carModel : carModels) {
            if (carModel.getBrand().equalsIgnoreCase(brand)) {
                models.add(carModel.getModel());
            }
        }
        return models;
    }

    public Map<String, Integer> groupByBrand() {
        Map<String, Integer> brandCounts = new HashMap<>();
        for (CarModelDTO carModel : carModels) {
            brandCounts.merge(carModel.getBrand(), 1, Integer::sum);
        }
        return brandCounts;
    }

    public List<CarDTO> generateCars(DealerCenter dealerCenter, int count) {
        List<CarDTO> cars = new ArrayList<>();
        String[] conditions = {"Не занят", "В пути", "В наличии", "Продан", "Забронирован"};
        String[] configurations = {"Базовая", "Средняя", "Максимальная"};
        String[] colors = {"Красный", "Синий", "Черный", "Белый", "Серый"};

        for (int i = 0; i < count; i++) {
            String id = "CAR" + (i + 1);
            CarModelDTO carModel = carModels.get(random.nextInt(carModels.size()));
            String condition = conditions[random.nextInt(conditions.length)];
            String configuration = configurations[random.nextInt(configurations.length)];
            String color = colors[random.nextInt(colors.length)];
            double price = 20000 + random.nextDouble() * 30000;

            CarDTO car = new CarDTO(id, carModel, dealerCenter, condition, configuration, color, price);
            cars.add(car);
            dealerCenter.addCar(car);
        }
        return cars;
    }

    public long measureExecutionTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - startTime;
    }

    // Класс Main
    public static class Main {
        public static void main(String[] args) {
            try {
                CarService carService = new CarService("JavaCars.txt");
                DealerCenter dealerCenter = new DealerCenter("Auto Dealer");

                long executionTime = carService.measureExecutionTime(() -> {
                    carService.generateCars(dealerCenter, 10);
                });

                System.out.println("Generated cars in " + executionTime + " ms");
                System.out.println(dealerCenter);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
