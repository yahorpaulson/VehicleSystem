package yahor.progects.omi.vehicles;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Workshop> list = new ArrayList<>();


        Brand BMW = new Brand("BMW", "Germany", "12345678", "www.bmwgroup.com");
        Brand Scoda = new Brand("Scoda", "Czech Republic", "87654321", "skoda-auto.com");
        Brand Tesla = new Brand("Tesla", "USA", "123456787654321", "www.tesla.com");
        Brand Porsche = new Brand("Porsche", "Germany", "876543212345678", "www.porsche.com");

        Workshop Austria = new Workshop("Werkstatt Klagenfurt",
                "Austria",
                9020,
                "Klagenfurt",
                "Voelkermarkter str",
                "+4312345678");
        Workshop Russia = new Workshop("Автомастерская на Щёлковской",
                "Russia",
                107207,
                "Moscow",
                "Highway Shchelcovskoe",
                "+74996774343");

        list.add(Austria);
        list.add(Russia);


        VehicleAdministration admin = new VehicleAdministration();
        admin.addVehicle(new Vehicle(1, BMW.getName(), BMW, list, 4, 3, 300));
        admin.addVehicle(new Vehicle(2, Scoda.getName(), Scoda, list, 2, 1, 250));

        admin.printAllVehicles();



    }

}
