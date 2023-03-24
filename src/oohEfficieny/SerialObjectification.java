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
            for(Object w: arr) {
                wf.writeObject(w);
            }
            wf.flush();
            wf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<SerialObjectification> ReadClassFile(String fname) {
        ArrayList<SerialObjectification> arr = new ArrayList<>();
        boolean cont = true;
        try (ObjectInputStream rf = new ObjectInputStream(new FileInputStream(fname))){

            while (cont) {
                Object obj = null;
                try {
                    obj =  rf.readObject();
                } catch (IOException e) {
                    break;
                }
                if (obj != null)
                    arr.add((SerialObjectification) obj);
                else
                    cont = false;
            }

        } catch (EOFException e) {
            return arr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Age: " + age + " Height: " + height;
    }

}
