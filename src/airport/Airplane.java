package airport;

public class Airplane {
    private  String planeId;
    private boolean isCurrentlyFlying;
    private double speed;


    public void airplaneTakeOff() {
        if(this.isCurrentlyFlying==false){
            this.isCurrentlyFlying = true;
            System.out.println("Airplane " + this.planeId + " rises.");
        }else{
            System.out.println("Airplane " + this.planeId + " can not take off, because we are already flying.");
        }

    }

    public void airplaneLand() {
        if(this.isCurrentlyFlying==true){
            this.isCurrentlyFlying = false;
            this.speed = 0;
            System.out.println("Airplane " + this.planeId + " lands.");
        }else{
            System.out.println("Airplane " + this.planeId + " can not land, because we are still on the ground. ");
        }
    }

    public void avarageMeasurement(){
        System.out.println("500m is a avarage measurement for a plane");
    }



    //Getter Setter constructor

    public Airplane(String planeId,  boolean isCurrentlyFlying, double speed) {
        this.planeId = planeId;
        this.isCurrentlyFlying = isCurrentlyFlying;
        this.speed = speed;
    }

    public String getPlaneId() {return planeId;}

    public void setPlaneId(String planeId) {this.planeId = planeId;}

    public boolean isCurrentlyFlying() {return isCurrentlyFlying;}

    public void setCurrentlyFlying(boolean currentlyFlying) {isCurrentlyFlying = currentlyFlying;}

    public double getSpeed() {return speed;}

    public void setSpeed(double speed) {this.speed = speed;}


}
