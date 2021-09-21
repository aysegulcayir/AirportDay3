package airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Airport {
    private String name;
    private List<PeoplePlane> airplanes;
    private List<CargoPlane> cargoPlanes;


    public List<PeoplePlane> getAllAircraft() {
        System.out.println("Aircraft from airport " + this.getName() + " :");
        for (PeoplePlane airplane : airplanes) {
            System.out.println("Passenger Airplane: " + airplane.getPlaneId());
        }
        return airplanes;
    }

    public List<CargoPlane> getAllCargoPlanes() {
        System.out.println("Cargo Aircraft from airport " + this.getName() + " :");
        for (CargoPlane cAirplane : cargoPlanes) {
            System.out.println("Cargo Airplane: " + cAirplane.getPlaneId());
        }
        return cargoPlanes;
    }

    public List<PeoplePlane> getSuitablePlane(int numberOfPassenger) {
        List<PeoplePlane> suitableAirplanes = new ArrayList<>();

        for (PeoplePlane airplane : airplanes) {

            if (airplane.isCurrentlyFlying() == false & ((airplane.getCurrentNumberOfPassengers() + numberOfPassenger) < airplane.getMaxNumberOfPassenger())) {
                suitableAirplanes.add(airplane);
                System.out.println("Plane " + airplane.getPlaneId() + " requested. Is not flying, still room for " +
                        (airplane.getMaxNumberOfPassenger() - (airplane.getCurrentNumberOfPassengers() + numberOfPassenger)) + " passengers.");

            }
            if ((airplane.getCurrentNumberOfPassengers() + numberOfPassenger) >= airplane.getMaxNumberOfPassenger()) {
                System.out.println("Plane " + airplane.getPlaneId() + " loads " + airplane.getCurrentNumberOfPassengers() + " passengers, " +
                        ((airplane.getCurrentNumberOfPassengers() + numberOfPassenger) - airplane.getMaxNumberOfPassenger()) + " do not fit into the plane.");
            }
            if (airplane.isCurrentlyFlying() == true & ((airplane.getCurrentNumberOfPassengers() + numberOfPassenger) < airplane.getMaxNumberOfPassenger())) {
                System.out.println("Plane " + airplane.getPlaneId() + " loads " + airplane.getCurrentNumberOfPassengers() + " passengers, " +
                        (airplane.getMaxNumberOfPassenger() - (airplane.getCurrentNumberOfPassengers() + numberOfPassenger)) + " fit into plane");
            }
        }
        return null;
    }

    public List<CargoPlane> getSuitableCargoPlane(int ton) {
        List<CargoPlane> suitableAirplanes = new ArrayList<>();

        for (CargoPlane airplane : cargoPlanes) {

            if (airplane.isCurrentlyFlying() == false & ((airplane.getCapacity() + ton) < 20)) {
                suitableAirplanes.add(airplane);
                System.out.println("Plane " + airplane.getPlaneId() + " requested. Is not flying, still room for " +
                        (20 - (airplane.getCapacity() + ton)) + " tons of freight");

            }
            if (airplane.isCurrentlyFlying() == false & (airplane.getCapacity()) + ton >= 20) {
                System.out.println("Plane " + airplane.getPlaneId() + " loads " + airplane.getCapacity() + " tons of cargo, " +
                        ((airplane.getCapacity() + ton) - 20) + " does not fit into the plane.");
            }
            if (airplane.isCurrentlyFlying() == true & (airplane.getCapacity()) + ton < 20) {
                System.out.println("Plane " + airplane.getPlaneId() + " loads " + airplane.getCapacity() + " tons of cargo, " +
                        (20-(airplane.getCapacity() + ton)) + "  fits into the plane..");
            }
        }
        return null;
    }

    public int loadPassenger(PeoplePlane airplane, int numberPassenger) {
        airplane.setCurrentNumberOfPassengers(numberPassenger);
        return airplane.getCurrentNumberOfPassengers();
    }

    public int loadCargo(CargoPlane cargoPlane, int capacity) {
        cargoPlane.setCapacity(capacity);
        return cargoPlane.getCapacity();
    }

    public void singlePeoplePlaneCheckStatusLand(PeoplePlane peoplePlane) {
        if (peoplePlane.isCurrentlyFlying() == false)
            System.out.println(peoplePlane.getPlaneId() + " is not flying.");

    }

    public void singleCargoPlaneCheckStatusLand(CargoPlane cargoPlane) {
        if (cargoPlane.isCurrentlyFlying() == false)
            System.out.println(cargoPlane.getPlaneId() + " is not flying.");

    }



//Getter and Setter Constructor

    public Airport(String name, List<PeoplePlane> airplanes, List<CargoPlane> cargoPlanes) {
        this.name = name;
        this.airplanes = airplanes;
        this.cargoPlanes = cargoPlanes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PeoplePlane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<PeoplePlane> airplanes) {
        this.airplanes = airplanes;
    }

//    public String toString() {

//        CargoPlane airplane1 = null;
        
//            return "planeId: " + airplane1.getPlaneId() + "status: " + airplane1.isCurrentlyFlying() +
//                    " speed: " +airplane1.getSpeed() +" capacity: " + airplane1.getCapacity();
       
//            return "planeId: " + airplane.getPlaneId() + "status: " + airplane.isCurrentlyFlying() +
//                    " speed: " +airplane.getSpeed() +" capacity: " + airplane.getMaxNumberOfPassenger()+"current passenger:"+ airplane.getCurrentNumberOfPassengers();

   // }


}
