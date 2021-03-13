package yahor.progects.omi.vehicles;

import java.util.ArrayList;
import java.util.Collections;

public class VehicleAdministration {

    private ArrayList<Vehicle> vehicles; //declaration of a list of vehicles


    public VehicleAdministration(){
        vehicles = new ArrayList<>(); //initialisation  with a constructor as a new empty list of vehicles
    }

    /**
     * Method creates a new Vehicle and calls a method to add this vehicle to the list
     */

    public void addVehicle(String name, Brand brand, ArrayList<Workshop> workshop, int weight, int maxPermissibleWeight, double maxSpeed){
        Vehicle vehicle = new Vehicle(name, brand, workshop, weight, maxPermissibleWeight, maxSpeed);
        addVehicle(vehicle);
    }

    /**
     * Method adds a new Vehicle in the list if the id is different
     */

    public void addVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if(!vehicles.contains(vehicle.getId())){
            vehicles.add(vehicle);
        } else
            throw new IllegalArgumentException("The vehicle should have an unique id");
    }


    /**
     * Method that removes Vehicle from the list
     */

    public void removeVehicle(int vehicleID){
        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getId() == vehicleID){
                vehicles.remove(i);
            }
        }
    }

    /**
     * Method that searches Vehicle in the list by it's ID
     */

    public void search(int vehicleID){
        boolean state = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getId() == vehicleID){
                vehicles.get(i).printInfo();
                state = true;
            }
        }
        if (!state){
            System.out.println("There's no vehicle with ID:" + vehicleID);
        }
    }
    /**
     * Method print all Vehicles from the list
     */

    public void printAllVehicles(){
        for (Vehicle v : vehicles){
            v.printInfo();
        }
    }

    /**
     *  Method sorts the list of Vehicles by it's weight.
     *  It compares two neighbour elements to each other by its weight.
     *  If the weight of the 1st element is greater than 2, the elements are swapping and it starts to comparing from the begining,
     *  if not than it goes to the next element. It's made with a recursion.
     *  UPD: method don't change the existing method but creates a new list with sorted elements.
     */

    private void sortAllVehiclesByWeight(){
        ArrayList <Vehicle> sortedVehicleList = new ArrayList<>(vehicles);
        for (int i = 0; i < vehicles.size()-1; i++) {
            if(sortedVehicleList.get(i).getWeight() > sortedVehicleList.get(i+1).getWeight()){
                Collections.swap(sortedVehicleList, i ,i+1);
                sortAllVehiclesByWeight();
            }
        }
    }

    /**
     * Method prints a sorted list by weight
     */

    public void printAllVehiclesByWeight(){
        System.out.println("The vehicles are sorted by it's weight... \n" +
                "*********************");
        sortAllVehiclesByWeight();
        printAllVehicles();
    }

    /**
     * Method searches all vehicles by it's name and shows on display all information about them
     */

    public void search(String brandName){
        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getName() == brandName){
                vehicles.get(i).printInfo();
            }
        }
    }
}
