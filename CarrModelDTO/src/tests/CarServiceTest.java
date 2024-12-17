package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCar.CarDTO;
import projectCar.CarService;
import projectCar.DealerCenter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() throws IOException {
        // Инициализация CarService с тестовым файлом
        carService = new CarService("JavaCarsTest.txt");
    }

    @Test
    void testGetUniqueBrands() {
        Set<String> uniqueBrands = carService.getUniqueBrands();
        assertNotNull(uniqueBrands);
        assertTrue(uniqueBrands.contains("Toyota"));
        assertTrue(uniqueBrands.contains("Ford"));
        assertFalse(uniqueBrands.contains("NonExistingBrand"));
    }

    @Test
    void testGetModelsByBrand() {
        List<String> models = carService.getModelsByBrand("Toyota");
        assertNotNull(models);
        assertTrue(models.contains("Camry"));
        assertTrue(models.contains("Corolla"));
    }

    @Test
    void testGroupByBrand() {
        Map<String, Integer> brandCounts = carService.groupByBrand();
        assertNotNull(brandCounts);
        assertEquals(2, brandCounts.get("Toyota")); // Допустим, 2 модели Toyota
        assertEquals(1, brandCounts.get("Ford"));   // Допустим, 1 модель Ford
    }

    @Test
    void testGenerateCars() {
        DealerCenter dealerCenter = new DealerCenter("TestCenter");
        List<CarDTO> cars = carService.generateCars(dealerCenter, 3);

        assertNotNull(cars);
        assertEquals(3, cars.size());
        assertEquals(3, dealerCenter.getCars().size());
    }
}
