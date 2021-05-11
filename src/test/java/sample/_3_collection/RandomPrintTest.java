package sample._3_collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomPrintTest {
    @Test
    public void 値が0のマップを作るテスト(){
        RandomPrint sut = new RandomPrint();
        Map.Entry<String,Integer> actual = sut.toMap(Arrays.asList(new String[]{"a"})).entrySet().iterator().next();
        assertThat(actual.getKey(), is("a"));
        assertThat(actual.getValue(), is(0));
    }

    @Test
    public void 要素数が1のマップに住まわせるテスト(){
        Map<String,Integer> m = new HashMap<>();
        m.put("a", 0);
        RandomPrint sut = new RandomPrint();
        sut.populate(m);
        assertThat(m.get("a"), is(100));
    }

    @Test
    public void 要素数が2のマップに住まわせるテスト(){
        Map<String,Integer> m = new HashMap<>();
        m.put("a", 0);
        m.put("b", 0);
        RandomPrint sut = new RandomPrint();
        sut.populate(m);
        assertThat(m.get("a") + m.get("b"), is(100));
    }
}
