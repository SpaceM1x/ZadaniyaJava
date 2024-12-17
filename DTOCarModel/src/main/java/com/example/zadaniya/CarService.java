package com.example.zadaniya;

import java.util.*;
import java.util.stream.Collectors;

// Сервис для работы с коллекциями автомобилей
public class CarService {
    private List<CarDTO> carList;

    public CarService(List<CarDTO> carList) {
        this.carList = carList;
    }

    // Оценка производительности метода
    public void measurePerformance(Runnable method, String methodName) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        System.out.println(methodName + " выполнен за " + (endTime - startTime) / 1_000_000 + " мс.");
    }

    // 1. Метод для получения уникальных марок автомобилей
    public Set<String> getUniqueCarBrands() {
        return carList.stream()
                .map(car -> car.getCarModel().getBrand()) // Получаем марку из CarModelDTO
                .collect(Collectors.toSet());
    }

    // 2. Метод для поиска моделей по марке автомобиля
    public List<String> getModelsByBrand(String brand) {
        return carList.stream()
                .filter(car -> car.getCarModel().getBrand().equalsIgnoreCase(brand))
                .map(car -> car.getCarModel().getModel())
                .collect(Collectors.toList());
    }

    // 3. Группировка автомобилей по марке с подсчётом количества
    public Map<String, Integer> getCarCountByBrand() {
        return carList.stream()
                .collect(Collectors.groupingBy(car -> car.getCarModel().getBrand(), Collectors.summingInt(e -> 1)));
    }

    // 4. Фильтрация автомобилей по состоянию
    public List<CarDTO> getCarsByCondition(String condition) {
        return carList.stream()
                .filter(car -> car.getCondition().equalsIgnoreCase(condition))
                .collect(Collectors.toList());
    }

    // 5. Поиск автомобиля по ID
    public Optional<CarDTO> findCarById(String id) {
        return carList.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    // 6. Получение списка автомобилей с фильтрацией по марке
    public List<CarDTO> getCarsByBrand(String brand) {
        return carList.stream()
                .filter(car -> car.getCarModel().getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    // 7. Группировка моделей автомобилей по их наименованию
    public Map<String, Integer> getCarModelGroupByModel(String brand) {
        return carList.stream()
                .filter(car -> car.getCarModel().getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.groupingBy(car -> car.getCarModel().getModel(), Collectors.summingInt(e -> 1)));
    }
}
