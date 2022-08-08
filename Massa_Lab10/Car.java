public class Car {
    public static final String[] GEARS = {"Parked", "Drive", "Reverse"};

    String owner;
    String gear;
    int odometer;
    boolean gasPedalPushed;

    public Car(String ownerName) {
        owner = ownerName;
        gear = "Parked";
        odometer = 0;
        gasPedalPushed = false;
    }

    /**  * shifts the car into the given gear.
     * If a valid gear is  not given, do nothing.  *  
     * * @param newGear valid values are "Parked", "Drive", and "Reverse" 
     */

    public void shift(String newGear) {
        for (String gearString : GEARS)
            if (newGear.equalsIgnoreCase(gearString)) {
                gear = gearString;
            }

    }

    public String getOwner(){
        return owner;
    }

    public String getGear(){
        return gear;
    }
    public int getOdometer(){
        return odometer;
    }
    public boolean isAccelerating(){
        return gasPedalPushed;
    }

    public void move (int distance){
        String drive = GEARS[1];
        String reverse = GEARS[2];
        if (distance > 0 && isAccelerating()){
            if (getGear().equals(drive)){
                odometer += distance;
            } else if (getGear().equals(reverse)){
                odometer -= distance;
            }
        }
    }

    public String toString(){
        String gasPedalStatus;
        if (isAccelerating()){
            gasPedalStatus = "gas";
        } else{
            gasPedalStatus = "brake";
        }
        return (getOwner() + " is in " + getGear() + " & pressing " + gasPedalStatus + "; Distance: " + getOdometer());

    }
}
