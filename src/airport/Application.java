package airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        PeoplePlane airplane1 = new PeoplePlane("ABC123", true, 0, 43, 100);
        PeoplePlane airplane2 = new PeoplePlane("DDD88", true, 0, 23, 100);
        List<PeoplePlane> airplanes = new ArrayList<>(Arrays.asList(
                new PeoplePlane("ABC123", true, 0, 33, 5),
                new PeoplePlane("DDD88", true, 0, 23, 15),
                new PeoplePlane("DEAM88", false, 0, 23, 0)));


        List<CargoPlane> cargoPlanes = new ArrayList<>(Arrays.asList(
                new CargoPlane("FF2134", false, 100, 13),
                new CargoPlane("PLA166", false, 100, 13)));

        Airport airport1 = new Airport("Eindhoven", airplanes, cargoPlanes);
        airport1.getAllAircraft();
        airport1.getAllCargoPlanes();
        airport1.getSuitablePlane(21);
        airport1.getSuitableCargoPlane(25);



        System.out.println("Test");
        airplane1.loadPassenger(43);
        airplane1.airplaneTakeOff();
        airplane2.loadPassenger(23);
        airplane1.airplaneLand();
        airplane1.unloadPassenger(43);
        airplane2.airplaneTakeOff();
        airplane2.airplaneLand();
        airplane2.unloadPassenger(23);

        System.out.println(cargoPlanes.get(0).toString());;
        System.out.println("Test");
    }
}
