package sample._1_greeting;

import org.junit.Before;
import org.junit.Test;
import sample.PrintTesHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {
    @Before
    public void setup(){
        PrintTesHelper.setup();
    }

    @Test
    public void test(){
        HelloWorld.main(new String[]{});
        assertThat(PrintTesHelper.printed(), is("Hello World\r\n"));
    }
}
