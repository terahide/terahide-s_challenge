package sample;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintTesHelper {
    private static OutputStream out;
    public static void setup(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }
    public static String printed() {
        return PrintTesHelper.out.toString();
    }
}
