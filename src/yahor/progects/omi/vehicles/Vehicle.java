package yahor.progects.omi.vehicles;

import java.util.ArrayList;

public class Vehicle {
    private long id;
    private String name;
    private Brand brand;
    private ArrayList<Workshop> workshops;
    private int weight;
    private int maxPermissibleWeight;
    private double speed;
    private double maxSpeed;

    private static long nextID = 0;

    public Vehicle(
            String name,
            Brand brand,
            ArrayList <Workshop> workshops,
            int weight,
            int maxPermissibleWeight,
            double maxSpeed){

        this.name = name;
        this.brand = brand;
        this.workshops = workshops; //why for each Vehicle we have to create a new ArrayList with workshops
        this.weight = weight;
        this.maxPermissibleWeight = maxPermissibleWeight;
        this.speed = 0;
        this.maxSpeed = maxSpeed;
        this.id = getnextID();
    }

    public long getId() { //getter is made for checking in a list of vehicles 2 vehicles with the same id
        return this.id;
    }   //getter is used for searching an element by it's ID

    /**
     * Method increases vehicle's speed on 10. The max possible value of the speed will equal max speed;
     */

    public int getWeight() { return this.weight;}   //getter is used for sorting elements in a list by their weight

    public String getName() { return this.name;}    //getter is usec for searching by vehicle's name

    public double accelerate(){
        if (speed <= maxSpeed-10){
            speed += 10;
            System.out.println("The Vehicle " + this.name + " is increasing it's speed...");
            return speed;
        } else {
            System.out.println("The Vehicle " + this.name + " is on it's max speed...");
            speed = maxSpeed;
            return speed;
        }
    }

    /**
     * Method decreases vehicle's speed on 10. The least value of the speed is 0;
     */

    public double brake(){
        if(speed >= 10){
            speed -= 10;
            System.out.println("The Vehicle " + this.name + " is decreasing it's speed...");
            System.out.println(speed);
            return speed;
        } else {
            System.out.println("The vehicle " + this.name + " has stopped...");
            speed = 0;
            return speed;
        }
    }

    /**
     * Method of drive simulation.
     * Each kilometer the vehicle increases and decreases it's speed 3 times while driving.
     */

    public void drive(int kilometers){
        for (int i = 0; i < kilometers; i++) {
            for (int j = 0; j < 3; j++) {
                accelerate();
                brake();
            }
        }
        System.out.println("Vehicle "  + this.name + " has made a test-drive...");

    }

    /**
     * Method that shows all information about the vehicle
     */

    public void printInfo(){
        System.out.println(
                "ID Num " + this.id +
                "\nVehicle: " + this.name +
                "\nBrand: " + this.brand.getName() +
                "\nWeight: " + this.weight +
                "\nMax Permissible Weight: " + this.maxPermissibleWeight +
                "\nSpeed: " + this.speed +
                "\nMax Speed: " + this.maxSpeed+
                "\n___________________________");
    }

    /**
     * Method returns the definite workshop by it's post code and shows the it's name if the post code matches.
     * If not the method throws an exception
     */

    //TODO: if the post code is not in the list throw an exception
    public Workshop getWorkshop(int postCode){

        for (int i = 0; i < workshops.size(); i++) {
            if (workshops.get(i).getPostCode() == postCode) {
                System.out.println(workshops.get(i).getName());
                return workshops.get(i);
            }
        }
        return workshops.get(0);

    }

    private static long getnextID(){
        nextID++;
        return nextID;
    }
}
