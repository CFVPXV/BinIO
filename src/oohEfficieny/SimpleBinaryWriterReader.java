package oohEfficieny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleBinaryWriterReader {

    public SimpleBinaryWriterReader(){

    }

    public void WriteFile(String name){

        try{
            FileOutputStream fw = new FileOutputStream(name);

            for(int i = 0; i < 100; i++){
                fw.write(i);
            }

            //Flush not needed on Windows, but maybe linux
            fw.flush();
            fw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile(String name){

        try {
            FileInputStream fr = new FileInputStream(name);
            int value;

            //Not the most eloquent solution, what if we want to read -1?
            while((value = fr.read()) != -1){
                System.out.println("Value read is: " + value);
            }

            fr.close();
        }

        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
