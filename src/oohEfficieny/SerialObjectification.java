package oohEfficieny;

import java.io.*;
import java.util.ArrayList;

public class SerialObjectification implements Serializable {

    private String name;
    private int age;
    private float height;
    private String fname;

    SerialObjectification(){
    }
    SerialObjectification(String n, int a, float h){
        name = n;
        age = a;
        height = h;
    }

    public void declareFname(String fname){
        this.fname = fname;
    }
    public static void WriteClassFile(String fname, ArrayList<SerialObjectification> arr){

        try {
            ObjectOutputStream wf = new ObjectOutputStream(new FileOutputStream(fname));
            for(SerialObjectification w: arr) {
                wf.writeObject(w);
            }
            wf.flush();
            wf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SerialObjectification ReadClassFile(String fname) {

        try {
            ObjectInputStream rf = new ObjectInputStream(new FileInputStream(fname));
            System.out.println(rf.getClass());
            SerialObjectification gnu = (SerialObjectification) rf.readObject();
            System.out.println(gnu.getClass());
            return gnu;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Name: " + name + " Age: " + age + " Height: " + height;
    }

}
