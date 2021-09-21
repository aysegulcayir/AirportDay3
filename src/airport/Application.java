package airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        PeoplePlane airplane1 = new PeoplePlane("ABC123", true, 0, 43, 100);
        PeoplePlane airplane2 = new PeoplePlane("DDD88", true, 0, 23, 100);
        List<PeoplePlane> airplanes = new ArrayList<>(Arrays.asList(
                new PeoplePlane("ABC123", true, 100, 33, 5),
                new PeoplePlane("DDD88", true, 0, 23, 15),
                new PeoplePlane("DEAM88", false, 0, 23, 0)));


        List<CargoPlane> cargoPlanes = new ArrayList<>(Arrays.asList(
                new CargoPlane("FF2134", false, 0, 13),
                new CargoPlane("PLA166", false, 100, 13)));
        List<Airplane> planes = new ArrayList<>(Arrays.asList(
                new Airplane("ABC123", true, 100),
                new Airplane("FF2134",false,0)));


        Airport airport1 = new Airport("Eindhoven", airplanes, cargoPlanes, planes);
        airport1.getAllPeoplePlane();
        airport1.getAllCargoPlanes();
        airport1.getSuitablePlane(21);
        airport1.getSuitableCargoPlane(25);
        airport1.typeOfPlane("CargoPlane");
        System.out.println("....");
        airport1.WhichAirplanes("CargoPlanes");//does not work!!!!




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
        System.out.println();

        //polymorphism
        Airplane cargoAirplaneCast = new CargoPlane("FF2134", false, 100, 13);
        cargoAirplaneCast.avarageMeasurement();
        System.out.println();
        //cast
        Airplane airplaneCast= new PeoplePlane("ABC123", true, 0, 43, 16);
        System.out.println("CAST");
        System.out.println("------");
        System.out.println(airplaneCast.isCurrentlyFlying());

        Airplane par = airplaneCast;

        // Using instanceof to make sure that par
        // is a valid reference before typecasting
        if (par instanceof PeoplePlane)
        {
            System.out.println("Value accessed through " +
                    "parent reference with typecasting is " +
                    ((PeoplePlane)par).getCurrentNumberOfPassengers());
        }

        System.out.println(" ");

        //instance of
        for(PeoplePlane airplane:airplanes){
            if (airplane instanceof PeoplePlane)
                System.out.println("airplane " +airplane.getPlaneId() +" is instance of PeoplePlane");
            else
                System.out.println("airplane " +airplane.getPlaneId() +" is NOT instance of PeoplePlane");

            // instanceof returns true for Parent class also
            if (airplane instanceof Airplane)
                System.out.println("airplane " +airplane.getPlaneId() +"  is instance of Airplane");
            else
                System.out.println("airplane " +airplane.getPlaneId() +"  is NOT instance of Airplane");

            // instanceof returns true for all ancestors (Note : Object
            // is ancestor of all classes in Java)
            if (airplane instanceof Object)
                System.out.println("airplane " +airplane.getPlaneId() +"  is instance of Object");
            else
                System.out.println("airplane " +airplane.getPlaneId() +"  is NOT instance of Object");
        }

    }
}



