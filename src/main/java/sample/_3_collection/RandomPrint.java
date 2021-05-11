package sample._3_collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPrint {
    public static void main(String[] args){
        RandomPrint me = new RandomPrint();
        Map<String, Integer> m = me.toMap(Arrays.asList(new String[]{"a", "b", "c", "d"}));
        me.populate(m);
        m.entrySet().stream().forEach(e -> System.out.println(String.format("\"%s\" %d回", e.getKey(), e.getValue())));
    }

    public Map<String, Integer> toMap(List<String> list) {
        return list.stream().collect(Collectors.toMap(s -> s, s -> 0, (a ,b) -> a, TreeMap::new));
    }

    public void populate(Map<String, Integer> m){
        Random seed = new Random();
        IntStream.range(0,100).forEach(i->{
            String s = m.keySet().stream().collect(Collectors.toList()).get(seed.nextInt(m.size()));
            m.put(s, m.get(s)+1);
        });
    }
}
