package com.example.zadaniya;

import java.math.BigDecimal;

public class CarDTO {
    private String id;
    private CarModelDTO carModel; // Ссылка на модель автомобиля
    private DealerCenter dealerCenter; // Ссылка на дилерский центр
    private String condition; // Состояние автомобиля: "не занят", "в пути", "в наличии", "продан", "забронирован"
    private String configuration; // Комплектация
    private String color; // Цвет автомобиля
    private BigDecimal price; // Стоимость автомобиля

    public CarDTO(String id, CarModelDTO carModel, DealerCenter dealerCenter,
                  String condition, String configuration, String color, BigDecimal price) {
        this.id = id;
        this.carModel = carModel;
        this.dealerCenter = dealerCenter;
        this.condition = condition;
        this.configuration = configuration;
        this.color = color;
        this.price = price;
    }


    // Геттеры и сеттеры
    public String getId() { return id; }
    public CarModelDTO getCarModel() { return carModel; }
    public String getCondition() { return condition; }
    public String getConfiguration() { return configuration; }
    public String getColor() { return color; }
    public BigDecimal getPrice() { return price; }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id='" + id + '\'' +
                ", carModel=" + carModel +
                ", condition='" + condition + '\'' +
                ", configuration='" + configuration + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
