package sample._6_stream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollerTest {
    @Test
    public void _0行のテスト() {
        int[][] src = {};

        Roller sut = new Roller();
        int[][] actual = sut.rollLeft(src);
        assertThat(actual.length, is(0));
    }

    @Test
    public void _1行1コマのテスト() {
        int[][] src = {
                {1},
        };

        Roller sut = new Roller();
        int[][] actual = sut.rollLeft(src);
        //1
        assertThat(actual.length, is(1));
        assertThat(actual[0].length, is(1));

        assertThat(actual[0][0], is(1));
    }

    @Test
    public void _1行2コマのテスト() {
        int[][] src = {
                {1,2},
        };

        Roller sut = new Roller();
        int[][] actual = sut.rollLeft(src);
        //2
        //1
        assertThat(actual.length, is(2));
        assertThat(actual[0].length, is(1));
        assertThat(actual[1].length, is(1));

        assertThat(actual[0][0], is(2));
        assertThat(actual[1][0], is(1));
    }

    @Test
    public void _2行1コマのテスト() {
        int[][] src = {
                {1},
                {2},
        };

        Roller sut = new Roller();
        int[][] actual = sut.rollLeft(src);
        //1,2
        assertThat(actual.length, is(1));
        assertThat(actual[0].length, is(2));

        assertThat(actual[0][0], is(1));
        assertThat(actual[0][1], is(2));
    }

    @Test
    public void _2行2コマのテスト() {
        int[][] src = {
                {1,2},
                {3,4},
        };

        Roller sut = new Roller();
        int[][] actual = sut.rollLeft(src);
        //2,4
        //1,3
        assertThat(actual.length, is(2));
        assertThat(actual[0].length, is(2));
        assertThat(actual[1].length, is(2));

        assertThat(actual[0][0], is(2));
        assertThat(actual[0][1], is(4));
        assertThat(actual[1][0], is(1));
        assertThat(actual[1][1], is(3));
    }

    @Test
    public void test(){
        int[][] src = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };

        Roller sut = new Roller();
        int[][] actual = sut.rollLeft(src);
        //3,6,9
        //2,5,8
        //1,4,7
        assertThat(actual.length, is(3));
        assertThat(actual[0].length, is(3));
        assertThat(actual[1].length, is(3));
        assertThat(actual[2].length, is(3));

        assertThat(actual[0][0], is(3));
        assertThat(actual[0][1], is(6));
        assertThat(actual[0][2], is(9));
        assertThat(actual[1][0], is(2));
        assertThat(actual[1][1], is(5));
        assertThat(actual[1][2], is(8));
        assertThat(actual[2][0], is(1));
        assertThat(actual[2][1], is(4));
        assertThat(actual[2][2], is(7));
    }
}
