package airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Airport {
    private String name;
    private List<PeoplePlane> airplanes;
    private List<CargoPlane> cargoPlanes;
    private List<Airplane> planes;


    public List<PeoplePlane> getAllPeoplePlane() {
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

    public List<Airplane> typeOfPlane(String type) {
        List<Airplane> planeType = new ArrayList<>();
        if (type == "CargoPlane") {
            for (CargoPlane plane : getAllCargoPlanes()) {
                planeType.add(plane);
            }
        }
        if (type == "PeoplePlane") {
            for (PeoplePlane plane : getAllPeoplePlane()) {
                planeType.add(plane);
            }

        }
        return planeType;
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
                        (20 - (airplane.getCapacity() + ton)) + "  fits into the plane..");
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

    public void WhichAirplanes(String type) {
        System.out.printf("Passenger planes from airport %s:\n", this.name);
        if (type == "CargoPlane") ;
//        for(Airplane airplane:planes){
//            if(airplane instanceof PeoplePlane)
//                System.out.println(airplane.getPlaneId()+"  is People plane");
//            if(airplane instanceof CargoPlane)
//                System.out.println(airplane.getPlaneId()+"  is Cargo plane");
//        }
    }


//Getter and Setter Constructor

    public Airport(String name, List<PeoplePlane> airplanes, List<CargoPlane> cargoPlanes, List<Airplane> planes) {
        this.name = name;
        this.airplanes = airplanes;
        this.cargoPlanes = cargoPlanes;
        this.planes = planes;

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

    public List<CargoPlane> getCargoPlanes() {
        return cargoPlanes;
    }

    public void setCargoPlanes(List<CargoPlane> cargoPlanes) {
        this.cargoPlanes = cargoPlanes;
    }

    public List<Airplane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Airplane> planes) {
        this.planes = planes;
    }
}
