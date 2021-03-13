/**
 * Created by Yahor Paulson for Object Modeling and Implementation (620.102 Univ.-Ass. Haya Majid Qureshi, M.Sc. )
 */
package yahor.progects.omi.vehicles;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Workshop> list = new ArrayList<>(); //initialisation of a list of workshops


        /**
         * creating some brands with their parameters
         */

        Brand BMW = new Brand("BMW", "Germany", "12345678", "www.bmwgroup.com");
        Brand Scoda = new Brand("Scoda", "Czech Republic", "87654321", "skoda-auto.com");
        Brand Tesla = new Brand("Tesla", "USA", "123456787654321", "www.tesla.com");
        Brand Porsche = new Brand("Porsche", "Germany", "876543212345678", "www.porsche.com");

        /**
         * creating workshops with their parameters
         */

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

        /**
         * addind workshops in a list
         */

        list.add(Austria);
        list.add(Russia);

        /**
         * creating a vehicles administration
         */

        VehicleAdministration admin = new VehicleAdministration();
        admin.addVehicle( "x5", BMW, list, 4, 3, 300);
        admin.addVehicle( "Rapid", Scoda, list, 2, 1, 250);
        admin.addVehicle("Just Tesla", Scoda, list, 3, 1, 350);
        admin.addVehicle("One more Tesla", Tesla, list, 3, 3, 400);


        /**
         * Demonstration
         */

        //admin.printAllVehicles(); //demonstration of printing method working

        //admin.printAllVehiclesByWeight(); //demonstration of printing by weight method working

        //admin.removeVehicle(3); //demonstration of deleting a certain vehicle by ID

        //admin.search(3); //demonstration of searching a certain vehicle by ID

        //admin.printAllVehicles(); //demonstration of printing all vehicles in a list

        //admin.printAllVehiclesByWeight(); //demonstration of printing all vehicles in a sorted list

        //admin.search("Rapid");    //demo of searchin' vehicles by their name




    }

}
