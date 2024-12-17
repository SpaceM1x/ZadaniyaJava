package tests;

import org.junit.jupiter.api.Test;
import projectCar.CarModelDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CarModelDTOTest {

    @Test
    void testLoadFromFile() throws IOException {
        List<CarModelDTO> carModels = CarModelDTO.loadFromFile("JavaCarsTest.txt");
        assertNotNull(carModels);
        assertFalse(carModels.isEmpty());
    }

    @Test
    void testFindCarByModel() throws IOException {
        CarModelDTO carModelDTO = new CarModelDTO("", "", "", "");
        Optional<CarModelDTO> foundCar = carModelDTO.findCarByModel("Camry");

        assertTrue(foundCar.isPresent());
        assertEquals("Camry", foundCar.get().getModel());
    }

    @Test
    void testGetAllCarDTOs() throws IOException {
        CarModelDTO carModelDTO = new CarModelDTO("", "", "", "");
        List<CarModelDTO> carsByBrand = carModelDTO.getAllCarDTOs("Toyota");

        assertNotNull(carsByBrand);
        assertFalse(carsByBrand.isEmpty());
        assertTrue(carsByBrand.stream().allMatch(car -> car.getBrand().equalsIgnoreCase("Toyota")));
    }
}
