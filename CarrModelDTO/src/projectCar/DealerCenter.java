package projectCar;

import java.util.ArrayList;
import java.util.List;

public class DealerCenter {
    private String name;
    private List<CarDTO> cars;

    public DealerCenter(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void addCar(CarDTO car) {
        cars.add(car);
    }

    @Override
    public String toString() {
        return "DealerCenter{name='" + name + '\'' + ", cars=" + cars + '}';
    }
}
