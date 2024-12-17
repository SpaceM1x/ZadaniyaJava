package com.example.zadaniya;

import java.util.*;
import java.util.stream.Collectors;

// Интерфейс сервиса
public interface FileSystemCarModelService {
    void load(String fileName); // Загрузка файла

    List<CarModelDTO> getAllCarDTOs(String brand); // Возвращает список автомобилей по марке

    Optional<CarModelDTO> findCarById(CarModelDTO car); // Поиск автомобиля по id

    Map<String, Integer> getCarModelGroupByModel(String brand); // Группировка моделей по марке
}
