package oohEfficieny;

import java.io.*;

public class SerialObjectification implements Serializable {

    private String name;
    private int age;
    private float height;

    SerialObjectification(String n, int a, float h){
        name = n;
        age = a;
        height = h;
    }

    public static void WriteClassFile(String fname){

        try {
            ObjectOutputStream wf = new ObjectOutputStream(new FileOutputStream(fname));
            wf.writeObject(this);
            wf.flush();
            wf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SerialObjectification ReadClassFile(String fname){

        try {
            ObjectInputStream rf = new ObjectInputStream(new FileInputStream(fname));
            return (SerialObjectification) rf.readObject();
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
