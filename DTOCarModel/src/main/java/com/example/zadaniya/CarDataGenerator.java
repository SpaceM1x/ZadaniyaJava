package com.example.zadaniya;

import java.math.BigDecimal;
import java.util.*;

public class CarDataGenerator {
    private static final String[] CONDITIONS = {"не занят", "в пути", "в наличии", "продан", "забронирован"};
    private static final String[] CONFIGURATIONS = {"Базовая", "Комфорт", "Спорт", "Люкс"};
    private static final String[] COLORS = {"Красный", "Синий", "Черный", "Белый", "Серебристый"};
    private static final Random random = new Random();

    public static List<CarDTO> generateCarList(int count, List<CarModelDTO> models, DealerCenter dealer) {
        List<CarDTO> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CarModelDTO randomModel = models.get(random.nextInt(models.size()));
            carList.add(new CarDTO(
                    UUID.randomUUID().toString(),
                    randomModel,
                    dealer,
                    CONDITIONS[random.nextInt(CONDITIONS.length)],
                    CONFIGURATIONS[random.nextInt(CONFIGURATIONS.length)],
                    COLORS[random.nextInt(COLORS.length)],
                    BigDecimal.valueOf(10000 + random.nextInt(50000)) // Случайная стоимость
            ));
        }
        return carList;
    }
}
