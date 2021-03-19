package yahor.progects.omi.vehicles;

import java.util.ArrayList;

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
     *  Sorted with the bubble sorting method
     */

    public void printAllVehiclesByWeight(){
        ArrayList<Vehicle> vehiclesToSort = new ArrayList<>();
        for(Vehicle vehicle:vehicles) {
            vehiclesToSort.add(vehicle);
        }

        // Bubble Sort
        Vehicle tempVehicle;
        for(int i=0; i<vehiclesToSort.size()-1; i++) {
            for(int j=1; j<vehiclesToSort.size()-i; j++) {
                if(vehiclesToSort.get(j-1).getWeight()>vehiclesToSort.get(j).getWeight()) {
                    tempVehicle = vehiclesToSort.get(j-1);
                    vehiclesToSort.set(j-1, vehiclesToSort.get(j));
                    vehiclesToSort.set(j, tempVehicle);
                }
            }
        }

        for(Vehicle vehicle:vehiclesToSort) {
            vehicle.printInfo();
        }
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

    /**
     *  Filling up all the cars
     */

    public void fillUpAllCars(double fuel){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Car){
                ((Car) vehicle).fillUp(fuel);
            }
        }
        System.out.println("All cars are filled up on " +  fuel + "litres...");
    }

    /**
     * Charging up all electrocars
     */

    public void chargeAllElectricCars(double power, double hours){
        for (Vehicle vehicle: vehicles) {
            if(vehicle instanceof ElectricCar){
                ((ElectricCar) vehicle).charge(power, hours);
            }
        }
        System.out.println("Charged...");
    }
}
