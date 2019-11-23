package sample;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrintTest {
    @Before
    public void setup(){
        PrintTesHelper.setup();
    }

    @Test
    public void test(){
        System.out.print("hello");
        assertThat(PrintTesHelper.printed(), is("hello"));
    }

    private static class PrintTesHelper{
        private static OutputStream out;
        private static void setup(){
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
        }
        private static String printed() {
            return PrintTesHelper.out.toString();
        }
    }
}
