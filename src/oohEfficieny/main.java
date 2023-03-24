package oohEfficieny;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args){

        System.out.println("Welcome to your Localized Database about people's ages and height that you have for some reason");
        System.out.println("...you weirdo");

        Scanner scnr = new Scanner(System.in);
        String menuSelect;

        String db = "myWeirdDatabase";

        ArrayList<SerialObjectification> newObjs = new ArrayList<>();

        SerialObjectification currObject = new SerialObjectification();
        newObjs = currObject.ReadClassFile(db);

        boolean running = true;

        do{
            System.out.println("What would you like to do?");
            System.out.println("    a) Append to database");
            System.out.println("    p) Print out database");
            System.out.println("    q) Quit");

            menuSelect = scnr.next();

            switch(menuSelect){
                case "a":
                    System.out.println("Enter a name, age and height below");
                    String name = scnr.next();
                    int age = scnr.nextInt();
                    float height = scnr.nextFloat();
                    newObjs.add(new SerialObjectification(name, age, height));
                    break;
                case "p":
                    for(Object w: newObjs){
                        System.out.println(w.toString());
                    }
                    break;
                case "q":
                    SerialObjectification.WriteClassFile(db, newObjs);
                    System.out.println("Saving current session data...");
                    running = false;
                    break;
                default:
                    System.out.println("Not a proper selection!");
                    break;
            }
        }while(running != false);

        System.out.println("Shutting down...");
    }
}
