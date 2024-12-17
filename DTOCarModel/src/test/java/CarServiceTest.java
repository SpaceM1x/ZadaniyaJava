import com.example.zadaniya.CarModelDTO;
import com.example.zadaniya.CarService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class CarServiceTest {

    @Test
    public void testGetUniqueCarBrands() {
        List<CarModelDTO> carList = Arrays.asList(
                new CarModelDTO("1", "Toyota", "Camry", 2020),
                new CarModelDTO("2", "Honda", "Civic", 2018),
                new CarModelDTO("3", "Toyota", "Corolla", 2019)
        );
        CarService service = new CarService(carList);

        Set<String> uniqueBrands = service.getUniqueCarBrands();
        assertEquals(Set.of("Toyota", "Honda"), uniqueBrands);
    }

    @Test
    public void testGetModelsByBrand() {
        List<CarModelDTO> carList = Arrays.asList(
                new CarModelDTO("1", "Toyota", "Camry", 2020),
                new CarModelDTO("2", "Toyota", "Corolla", 2019),
                new CarModelDTO("3", "Honda", "Civic", 2018)
        );
        CarService service = new CarService(carList);

        List<String> models = service.getModelsByBrand("Toyota");
        assertEquals(List.of("Camry", "Corolla"), models);
    }

    @Test
    public void testGetCarCountByBrand() {
        List<CarModelDTO> carList = Arrays.asList(
                new CarModelDTO("1", "Toyota", "Camry", 2020),
                new CarModelDTO("2", "Toyota", "Corolla", 2019),
                new CarModelDTO("3", "Honda", "Civic", 2018)
        );
        CarService service = new CarService(carList);

        Map<String, Integer> carCount = service.getCarCountByBrand();
        assertEquals(2, carCount.get("Toyota"));
        assertEquals(1, carCount.get("Honda"));
    }
}
