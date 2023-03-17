package oohEfficieny;

public class main {

    public static void main(String[] args){
        SimpleBinaryWriterReader test = new SimpleBinaryWriterReader();

        test.WriteFile("Simpledata.dat");

        test.readFile("Simpledata.dat");


    }
}
