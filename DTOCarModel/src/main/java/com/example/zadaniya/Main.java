package com.example.zadaniya;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Генерация тестовых данных
        CarModelDTO toyotaCamry = new CarModelDTO("1", "Toyota", "Camry", 2020);
        CarModelDTO hondaCivic = new CarModelDTO("2", "Honda", "Civic", 2021);

        DealerCenter dc3 = new DealerCenter("");
        CarDTO car3 = new CarDTO("1003", toyotaCamry,"Toyota" , "в пути","config" ,"Чёрный", );

        List<CarDTO> cars = List.of( car3);
        CarService carService = new CarService(cars);

        // Получение уникальных марок
        Set<String> uniqueBrands = carService.getUniqueCarBrands();
        System.out.println("Уникальные марки: " + uniqueBrands);

        // Поиск моделей по марке
        List<String> toyotaModels = carService.getModelsByBrand("Toyota");
        System.out.println("Модели Toyota: " + toyotaModels);

        // Группировка автомобилей по марке
        Map<String, Integer> carCountByBrand = carService.getCarCountByBrand();
        System.out.println("Количество автомобилей по марке: " + carCountByBrand);

        // Фильтрация по состоянию
        List<CarDTO> availableCars = carService.getCarsByCondition("в наличии");
        System.out.println("Автомобили в наличии: " + availableCars.size());

        // Поиск автомобиля по ID
        Optional<CarDTO> carById = carService.findCarById("1001");
        carById.ifPresent(car -> System.out.println("Найден автомобиль: " + car.getCarModel().getModel()));

        // Группировка моделей по марке
        Map<String, Integer> modelGroup = carService.getCarModelGroupByModel("Toyota");
        System.out.println("Группировка моделей Toyota: " + modelGroup);
    }
}
