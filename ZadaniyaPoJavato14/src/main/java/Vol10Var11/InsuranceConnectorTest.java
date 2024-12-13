package Vol10Var11;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InsuranceConnectorTest {
    @Test
    public void testSaveAndLoadInsurance() throws IOException, ClassNotFoundException {
        String filePath = "insurance.dat";
        InsuranceConnector connector = new InsuranceConnector(filePath);
        List<Insurance> insurances = List.of(
                new Insurance("Life", 1000, 5),
                new Insurance("Health", 2000, 7)
        );

        connector.saveInsurance(insurances);
        List<Insurance> loadedInsurances = connector.loadInsurance();

        assertEquals(insurances, loadedInsurances);
        new File(filePath).delete();
    }

    @Test
    public void testSortByRisk() {
        InsuranceConnector connector = new InsuranceConnector("");
        List<Insurance> insurances = List.of(
                new Insurance("Life", 1000, 5),
                new Insurance("Health", 2000, 7),
                new Insurance("Property", 1500, 3)
        );

        List<Insurance> sorted = connector.sortByRisk(insurances);
        assertEquals("Health", sorted.get(0).toString().split("\\{")[0]);
    }
}
