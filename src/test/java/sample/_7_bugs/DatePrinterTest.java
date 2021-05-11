package sample._7_bugs;

import org.junit.Before;
import org.junit.Test;
import sample.PrintTesHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DatePrinterTest {
    @Before
    public void setup(){
        PrintTesHelper.setup();
    }

    @Test
    public void test() throws Exception {
        DatePrinter.main(new String[]{});
        String[] lines = PrintTesHelper.printed().split("\n");
        assertThat(lines.length, is(10000 + 2));//finish分
        assertThat(lines[0], is("2021.05.11"));
    }
}
