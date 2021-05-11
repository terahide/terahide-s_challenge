package sample._2_int;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.PrintTesHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ATest {
    @Before
    public void setup(){
        PrintTesHelper.setup();
    }

    @Test
    public void test(){
        Main.main(new String[]{});
        assertThat(PrintTesHelper.printed(), is("i=1\r\n"));
    }
}
