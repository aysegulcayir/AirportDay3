package airport;

public class CargoPlane extends Airplane {
    private int capacity;

    public CargoPlane(String planeId, boolean isCurrentlyFlying, double speed) {
        super(planeId, isCurrentlyFlying, speed);
        this.setType("CargoPlane");
    }

    public CargoPlane(String planeId, boolean isCurrentlyFlying, double speed, int capacity) {
        super(planeId, isCurrentlyFlying, speed);
        this.capacity = capacity;
        this.setType("CargoPlane");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void avarageMeasurement(){
        System.out.println("400 m is a avarage measurement for a plane");
    }

    public int loadCapacity(int ton) {
        this.capacity = this.getCapacity();
        if (this.capacity < 20) {
            this.capacity += ton;
            if (this.capacity <= 20) {
                System.out.println("Airplane " + this.getPlaneId() + " loads " + this.capacity + " tons of cargo suitable");
                return this.capacity;
            } else {
                System.out.println("Airplane " + this.getPlaneId() + " loads " + this.capacity + " tons of cargo," +
                        (this.capacity - 20) + " does not fit");
                return this.capacity;
            }
        } else {
            System.out.println("Airplane " + this.getPlaneId() + " loads " + this.capacity + " tons of cargo," +
                    (this.capacity - 20) + " does not fit");
            return this.capacity;
        }
    }

    public int unloadCapacity(int ton) {

        this.capacity -= ton;
        System.out.println("Airplane " + this.getPlaneId() + " unloads " + this.getPlaneId() + " tons.");
        return this.capacity;
    }
    public String toString(){
        return "planeId: " + this.getPlaneId() + " status: " + this.isCurrentlyFlying() +
                " speed: " +this.getSpeed() +" capacity: " + this.getCapacity();
    }


}
