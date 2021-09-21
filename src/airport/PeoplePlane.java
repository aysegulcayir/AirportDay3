package airport;

public class PeoplePlane extends Airplane{
    private int maxNumberOfPassenger;
    private int currentNumberOfPassengers;



    public int loadPassenger(int numberOfPassenger) {
        this.currentNumberOfPassengers = this.getCurrentNumberOfPassengers();
        if (this.currentNumberOfPassengers >= 0 | this.currentNumberOfPassengers < this.maxNumberOfPassenger) {
            this.currentNumberOfPassengers += numberOfPassenger;
            if (this.currentNumberOfPassengers <= this.maxNumberOfPassenger) {
                System.out.println("Airplane " + this.getPlaneId() + " charges " + this.currentNumberOfPassengers + " passengers.");
                return this.currentNumberOfPassengers;
            } else {
                System.out.println("Airplane " + this.getPlaneId()  + " charges " + this.maxNumberOfPassenger + " passengers," +
                        (this.currentNumberOfPassengers - this.maxNumberOfPassenger) + " do not fit");
                return this.currentNumberOfPassengers;
            }
        } else {
            System.out.println("Airplane " + this.getPlaneId()  + " charges " + this.maxNumberOfPassenger + " passengers," +
                    (this.currentNumberOfPassengers - this.maxNumberOfPassenger) + " do not fit");
            return this.currentNumberOfPassengers;
        }
    }

    public int unloadPassenger(int numberOfPassenger) {

        this.currentNumberOfPassengers -= numberOfPassenger;
        System.out.println("Airplane " + this.getPlaneId()  + " discharges " + numberOfPassenger + " passengers.");
        return this.currentNumberOfPassengers;
    }

    public void airplaneTakeOff() {
        if(this.isCurrentlyFlying()==false){
            this.setCurrentlyFlying(true) ;
            System.out.println("Airplane " + this.getPlaneId() + " rises.");
        }else{
            System.out.println("Airplane " + this.getPlaneId() + " can not take off, because we are already flying.");
        }

    }

    public void airplaneLand() {
        if(this.isCurrentlyFlying()==true){
            this.setCurrentlyFlying(false) ;
            this.setSpeed(0) ;
            System.out.println("Airplane " +  this.getPlaneId()+ " lands.");
        }else{
            System.out.println("Airplane " +  this.getPlaneId()+ " can not land, because we are still on the ground. ");
        }
    }
    public String toString(){
        return "planeId: " + this.getPlaneId() + " status: " + this.isCurrentlyFlying() +
                    " speed: " +this.getSpeed() +" capacity: " + this.getMaxNumberOfPassenger()+"current passenger:"+ this.getCurrentNumberOfPassengers();
    }


    //Getter Setter constructor


    public PeoplePlane(String planeId, boolean isCurrentlyFlying, double speed) {
        super(planeId, isCurrentlyFlying, speed);
        this.setType("PeoplePlane");
    }

    public PeoplePlane(String planeId,  boolean isCurrentlyFlying, double speed, int maxNumberOfPassenger, int currentNumberOfPassengers){
        super(planeId, isCurrentlyFlying, speed);
        this.maxNumberOfPassenger = maxNumberOfPassenger;
        this.currentNumberOfPassengers =currentNumberOfPassengers;
        this.setType("PeoplePlane");
    }


    public int getMaxNumberOfPassenger() {
        return maxNumberOfPassenger;
    }

    public void setMaxNumberOfPassenger(int maxNumberOfPassenger) {
        this.maxNumberOfPassenger = maxNumberOfPassenger;
    }

    public int getCurrentNumberOfPassengers() {
        return currentNumberOfPassengers;
    }

    public void setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
        this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

}
