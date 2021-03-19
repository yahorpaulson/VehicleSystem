package yahor.progects.omi.vehicles;

import java.util.ArrayList;

public class ElectricCar extends Vehicle{
    private double batteryLevel;
    private double maxBatteryCapacity;
    private double powerConsumption;

    public ElectricCar(
            String name,
            Brand brand,
            ArrayList<Workshop> workshops,
            int weight,
            int maxPermissibleWeight,
            double maxSpeed,
            double maxBatteryCapacity,
            double powerConsumption) {
        super(name, brand, workshops, weight, maxPermissibleWeight, maxSpeed);
        this.batteryLevel = 0;
        this.maxBatteryCapacity = maxBatteryCapacity;
        this.powerConsumption = powerConsumption;
    }


    //region GetSet
    public double getBatteryLevel() {
        return batteryLevel;
    }

    public double getMaxBatteryCapacity() {
        return maxBatteryCapacity;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setMaxBatteryCapacity(double maxBatteryCapacity) {
        this.maxBatteryCapacity = maxBatteryCapacity;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
    //endregion

    /**
     * Method of charging. In this method battery level directly depends on power and hours of charging
     */

    public void charge(double power, double hours){
        batteryLevel += (power * hours);

        if(batteryLevel > maxBatteryCapacity){
            batteryLevel = maxBatteryCapacity;
            System.out.println("This car is fully charged...");
        }
    }

    /**
     * Electrocar driving method. Accelerates at max speed while battery is full.
     * Then the car stops slowly.
     */

    @Override
    public void drive(int kilometres){
        for (int i = 0; i < kilometres; i++) {

            accelerate();
            batteryLevel -= powerConsumption;
            if (batteryLevel < 0){
                batteryLevel = 0;
                while (speed > 0){
                    this.brake();
                }
                System.out.println("The car has stopped...");
                break;
            }
        }

    }

    /**
     * Special method brake() for electric car
     */

    @Override
    public double brake(){
        if(speed > 0){
            batteryLevel += 0.001;
            speed -= 10;
            System.out.println("Speed is decreased on 10...");
        } else{
            speed = 0;
        }
        return speed;
    }

    /**
     * Overrided method shows info about a car
     */

    @Override
    public void printInfo(){
        System.out.println(
                "ID Num: " + getId() + "\n" +
                "Brand: " + getBrand().getName() + "\n" +
                "Car Name: " + getName() + "\n" +
                "Weight: " + getWeight() + "\n" +
                "Max Permissible Weight : " + getMaxPermissibleWeight() + "\n" +
                "Additional info**************************" + "\n" +
                "Battery Level: " + getBatteryLevel() + "\n" +
                "Max fuel: " + getMaxBatteryCapacity() + "\n" +
                "Power consumption: " + getPowerConsumption() + "\n" +
                "_____________________________"
        );
    }
}