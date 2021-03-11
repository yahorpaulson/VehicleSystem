package yahor.progects.omi.vehicles;

import java.util.ArrayList;

public class VehicleAdministration {

    private ArrayList<Vehicle> vehicles; //declaration of a list of vehicles


    public VehicleAdministration(){
        vehicles = new ArrayList<>(); //initialisation  with a constructor as a new empty list of vehicles
    }

    /**
     * Method adds a new Vehicle in the list
     */

    public void addVehicle(Vehicle vehicle){
        if(!vehicles.contains(vehicle.getId())){
            vehicles.add(vehicle);
        }
    }


    /**
     * Method that removes Vehicle from the list
     */

    public void removeVehicle(int vehicleID){
        if(vehicles.contains(vehicleID)){
            vehicles.remove(vehicleID);
        }
    }

    /**
     * Method that searches Vehicle in the list by it's ID
     */

    public void search(int vehicleID){
        if(vehicles.contains(vehicleID)){
            vehicles.get(vehicleID);
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
}
