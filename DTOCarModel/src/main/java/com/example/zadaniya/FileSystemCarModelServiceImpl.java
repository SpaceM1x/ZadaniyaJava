package com.example.zadaniya;

import java.util.*;
import java.util.stream.Collectors;

public class FileSystemCarModelServiceImpl implements FileSystemCarModelService {

    // Список автомобилей
    private List<CarModelDTO> carList = new ArrayList<>();

    // Загрузка данных в список (упрощенная версия)
    @Override
    public void load(String fileName) {
        carList.add(new CarModelDTO("1", "Toyota", "Camry", 2020));
        carList.add(new CarModelDTO("2", "Toyota", "Corolla", 2019));
        carList.add(new CarModelDTO("3", "Honda", "Civic", 2018));
        carList.add(new CarModelDTO("4", "Honda", "Accord", 2020));
        carList.add(new CarModelDTO("5", "BMW", "X5", 2022));
        System.out.println("Данные загружены.");
    }

    // Метод для получения всех машин по марке (фильтр)
    @Override
    public List<CarModelDTO> getAllCarDTOs(String brand) {
        return carList.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    // Метод для поиска автомобиля по ID
    @Override
    public Optional<CarModelDTO> findCarById(CarModelDTO car) {
        return carList.stream()
                .filter(c -> c.equals(car)) // Используем equals по id
                .findFirst();
    }

    // Группировка по модели с подсчетом количества
    @Override
    public Map<String, Integer> getCarModelGroupByModel(String brand) {
        return carList.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.groupingBy(CarModelDTO::getModel, Collectors.summingInt(e -> 1)));
    }

    // Тестируем методы
    public static void main(String[] args) {
        FileSystemCarModelService service = new FileSystemCarModelServiceImpl();

        // Загрузка данных
        service.load("cars.txt");

        // Сравнение объектов
        CarModelDTO car1 = new CarModelDTO("3", "Honda", "Civic", 2018);
        CarModelDTO car2 = new CarModelDTO("3", "Honda", "Civic", 2018);
        System.out.println("car1 equals car2? " + car1.equals(car2));

        // Проверка List.indexOf и List.contains
        List<CarModelDTO> list = new ArrayList<>();
        list.add(car1);

        System.out.println("List contains car2? " + list.contains(car2));
        System.out.println("Index of car2: " + list.indexOf(car2));

        // Получение всех автомобилей по марке
        System.out.println("Все Honda: " + service.getAllCarDTOs("Honda"));

        // Поиск по ID
        Optional<CarModelDTO> foundCar = service.findCarById(new CarModelDTO("2", "", "", 0));
        System.out.println("Найденный автомобиль: " + foundCar);

        // Группировка по моделям
        Map<String, Integer> grouped = service.getCarModelGroupByModel("Toyota");
        System.out.println("Группировка моделей Toyota: " + grouped);
    }
}
