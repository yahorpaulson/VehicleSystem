package yahor.progects.omi.vehicles;

import java.util.ArrayList;

public class Car extends Vehicle{

    private double fuel;
    private double maxFuel;
    private double fuelConsumtion;

    public Car(
            String name,
            Brand brand,
            ArrayList<Workshop> workshops,
            int weight,
            int maxPermissibleWeight,
            double maxSpeed,
            double maxFuel,
            double fuelConsumtion) {
        super(name, brand, workshops, weight, maxPermissibleWeight, maxSpeed);

        this.fuel = 0;
        this.maxFuel = maxFuel;
        this.fuelConsumtion = fuelConsumtion; //litres pro kilometer
    }

    //region Get/Set

    public double getFuel() {
        return fuel;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public double getFuelConsumtion() {
        return fuelConsumtion;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }

    //endregion

    /**
     * This method makes a drive test of the car
     */

    @Override
    public void drive(int kilometres) {

        int kilometerCounter = 0;

        for (int i = 0; i < kilometres; i++){
            accelerate();
            this.fuel -= fuelConsumtion;
            kilometerCounter++;
            if (this.fuel <= 0){
                this.fuel = 0;
                while (speed > 0){
                    this.brake();
                }
                System.out.println("The car is stopped. The Tank is empty. Reached kilometres: " + kilometerCounter);
                break;
            }
        }

    }

    /**
     * The method of refueling the gas tank
     */

    public void fillUp(double fuel){
        this.fuel += fuel;
        if(this.fuel > maxFuel){
            this.fuel = maxFuel;
            System.out.println("Ganz wohl getankt...");
        } else
            System.out.println("Fuel is increased on " + fuel + " litres...");
    }

    /**
     * Overriding the method with information about car information
     */

    @Override
    public void printInfo(){
        System.out.println(
                "ID Num: " + getId() + "\n" +
                "Brand: " + getBrand().getName() + "\n" +
                "Car Name: " + getName() + "\n" +
                "Weight: " + getWeight() + "\n" +
                "Max Permissible Weight : " + getMaxPermissibleWeight() + "\n" +
                "Additional info **********************\n" +
                "Fuel: " + getFuel() + "\n" +
                "Max fuel: " + getMaxFuel() + "\n" +
                "Fuel consumption: " + getFuelConsumtion() + "\n" +
                "_____________________________"
        );
    }
}
