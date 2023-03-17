package oohEfficieny;

import java.io.*;

public class ComplexBinaryReaderWriter {

    private String name;

    public ComplexBinaryReaderWriter(){
        name = "Ni";
    }

    public void WriteToFile(String name){
        try{
            ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream(name));

            //Problem is, when the class has many types being written to, we have to remember the order
            //of which it is written. It works like a queue, fifo
            wr.writeUTF(name);
            wr.flush();
            wr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadFromFile(String name){
        try{
            ObjectInputStream re = new ObjectInputStream(new FileInputStream(name));
            //etc...
            //This is where the java interface comes in, and enforce the use of specific function names
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
