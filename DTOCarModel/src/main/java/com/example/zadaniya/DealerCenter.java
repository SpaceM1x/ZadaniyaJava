package com.example.zadaniya;

import java.util.List;

public class DealerCenter {
    private String name;
    private List<CarDTO> carList; // Ссылка на список автомобилей

    public DealerCenter(String name, List<CarDTO> carList) {
        this.name = name;
        this.carList = carList;
    }

    public String getName() { return name; }
    public List<CarDTO> getCarList() { return carList; }

    @Override
    public String toString() {
        return "DealerCenter{" +
                "name='" + name + '\'' +
                ", carList=" + carList +
                '}';
    }
}
