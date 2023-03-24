package oohEfficieny;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args){

        System.out.println("Welcome to your Localized Database about people's ages and height that you have for some reason");
        System.out.println("...you weirdo");

        Scanner scnr = new Scanner(System.in);
        String menuSelect;

        String db = "myWeirdDatabase";

        ArrayList<SerialObjectification> objs = new ArrayList<SerialObjectification>();



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
                    objs.add(new SerialObjectification(scnr.nextLine(), scnr.nextInt(), scnr.nextFloat()));
                    break;
                case "p":
                    objs = (ArrayList<SerialObjectification>) SerialObjectification.ReadClassFile(db);
                    for(SerialObjectification w: objs){
                        System.out.println(w.toString());
                    }

            }
        }while(running != false);


    }
}
