package Vol12Var11;

public class Main {
    public static void main(String[] args) {
        int numAirplanes = 10; // Количество самолетов
        Airport airport = new Airport(numAirplanes);

        for (int i = 0; i < numAirplanes; i++) {
            Airplane airplane = new Airplane("Airplane-" + (i + 1),
                    (i % 2 == 0), // Чередование способа посадки
                    "Destination-" + (i % 4 + 1),
                    (i % 3 + 1) * 1000); // Зоны дальности
            airport.processAirplane(airplane);
        }

        airport.shutdown();
    }
}
