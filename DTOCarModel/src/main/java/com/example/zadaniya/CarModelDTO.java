package com.example.zadaniya;

import java.util.Objects;

// Класс модели данных для автомобиля
public class CarModelDTO {
    private String id;
    private String brand;
    private String model;
    private int year;

    // Конструктор
    public CarModelDTO(String id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "CarModelDTO{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModelDTO that = (CarModelDTO) o;
        return Objects.equals(id, that.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equalsByFields(CarModelDTO other) {
        return this.brand.equals(other.brand) &&
                this.model.equals(other.model) &&
                this.year == other.year;
    }
}
