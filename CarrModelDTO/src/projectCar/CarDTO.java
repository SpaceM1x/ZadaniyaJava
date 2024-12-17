package projectCar;

public class CarDTO {
    private String id;
    private CarModelDTO carModel;
    private DealerCenter dealerCenter;
    private String condition;
    private String configuration;
    private String color;
    private double price;

    public CarDTO(String id, CarModelDTO carModel, DealerCenter dealerCenter, String condition, String configuration, String color, double price) {
        this.id = id;
        this.carModel = carModel;
        this.dealerCenter = dealerCenter;
        this.condition = condition;
        this.configuration = configuration;
        this.color = color;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public CarModelDTO getCarModel() {
        return carModel;
    }

    public DealerCenter getDealerCenter() {
        return dealerCenter;
    }

    public String getCondition() {
        return condition;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("CarDTO{id='%s', model=%s, dealerCenter=%s, condition='%s', configuration='%s', color='%s', price=%.2f}",
                id, carModel, dealerCenter.getName(), condition, configuration, color, price);
    }
}
