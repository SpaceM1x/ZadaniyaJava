package projectCar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CarModelDTO {

    private final String brand; // Бренд
    private final String model; // Модель
    private final String countryOrigin; // Страна происхождения
    private final String countryCode; // Код страны

    public CarModelDTO(String brand, String model, String countryOrigin, String countryCode) {
        this.brand = brand;
        this.model = model;
        this.countryOrigin = countryOrigin;
        this.countryCode = countryCode;
    }

    public static List<CarModelDTO> loadFromFile(String filePath) throws IOException {
        List<CarModelDTO> carModels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            reader.readLine(); // Пропускаем заголовок
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) { // Проверка на количество частей
                    CarModelDTO carModel = new CarModelDTO(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                    carModels.add(carModel);
                }
            }
        }
        return carModels;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s, %s)", brand, model, countryOrigin, countryCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModelDTO that = (CarModelDTO) o;

        return brand.equals(that.brand) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    public List<CarModelDTO> getAllCarDTOs(String brand) throws IOException {
        List<CarModelDTO> filteredCars = new ArrayList<>();
        List<CarModelDTO> carModels = loadFromFile("JavaCars.txt");
        for (CarModelDTO carModel : carModels) {
            if (carModel.brand.equalsIgnoreCase(brand)) {
                filteredCars.add(carModel);
            }
        }
        return filteredCars;
    }

    public Optional<CarModelDTO> findCarByModel(String model) throws IOException {
        List<CarModelDTO> carModels = loadFromFile("JavaCars.txt");
        for (CarModelDTO carModel : carModels) {
            if (carModel.model.equalsIgnoreCase(model)) {
                return Optional.of(carModel);
            }
        }
        return Optional.empty();
    }

    public Map<String, Integer> getCarModelGroupByBrand(String brand) throws IOException {
        Map<String, Integer> modelCounts = new HashMap<>();
        List<CarModelDTO> carModels = loadFromFile("JavaCars.txt");
        for (CarModelDTO carModel : carModels) {
            if (carModel.brand.equalsIgnoreCase(brand)) {
                modelCounts.merge(carModel.model, 1, Integer::sum);
            }
        }
        return modelCounts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            List<CarModelDTO> carModels = loadFromFile("JavaCars.txt");
            System.out.println("Доступные автомобили:");
            for (CarModelDTO carModel : carModels) {
                System.out.println(carModel);
            }

            // Поиск автомобиля по модели
            System.out.print("Введите модель автомобиля для поиска: ");
            String modelInput = scanner.nextLine();
            Optional<CarModelDTO> foundCar = new CarModelDTO("", modelInput, "", "").findCarByModel(modelInput);
            foundCar.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Автомобиль с моделью " + modelInput + " не найден.")
            );

            // Получение всех автомобилей по марке
            System.out.print("Введите марку автомобиля для фильтрации: ");
            String brandInput = scanner.nextLine();
            List<CarModelDTO> filteredCars = new CarModelDTO("", "", "", "").getAllCarDTOs(brandInput);
            if (filteredCars.isEmpty()) {
                System.out.println("Автомобили с маркой " + brandInput + " не найдены.");
            } else {
                System.out.println("Автомобили с маркой " + brandInput + ":");
                filteredCars.forEach(System.out::println);
            }

            // Группировка автомобилей по марке
            System.out.print("Введите марку для группировки моделей: ");
            String groupBrandInput = scanner.nextLine();
            Map<String, Integer> groupedModels = new CarModelDTO("", "", "", "").getCarModelGroupByBrand(groupBrandInput);
            if (groupedModels.isEmpty()) {
                System.out.println("Нет автомобилей с маркой " + groupBrandInput + ".");
            } else {
                System.out.println("Группировка моделей для марки " + groupBrandInput + ":");
                groupedModels.forEach((model, count) -> System.out.println(model + ": " + count));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

}
