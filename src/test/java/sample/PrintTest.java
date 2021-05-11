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
}
