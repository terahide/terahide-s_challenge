package sample._4_fizzbuzz;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class FizzBuzzTest {
    @DataPoints
    public static List<Fixture> data(){
        return Arrays.asList(
                t(1, "1"),
                t(2, "2"),
                t(3, "Fizz"),
                t(5, "Buzz"),
                t(15, "FizzBuzz")
        );
    }

    @Theory
    public void test(Fixture fixture){
        FizzBuzz sut = new FizzBuzz();
        assertThat(sut.stringify(fixture.parameter), is(fixture.expected));
    }

    static Fixture t(int i, String s){
        Fixture c = new Fixture();
        c.parameter = i;
        c.expected = s;
        return c;
    }

    static class Fixture {
        int parameter;
        String expected;
    }

}

