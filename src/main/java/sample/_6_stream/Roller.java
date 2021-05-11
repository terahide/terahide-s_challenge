package sample._6_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Roller {
    public int[][] rollLeft(int[][] rows){
        if(rows.length == 0){
            return new int[][]{};
        }

        List<List<Integer>> box = new ArrayList<>();

        //setup
        Arrays.stream(rows[0]).forEach(i -> box.add(new ArrayList<>()));

        Arrays.stream(rows).forEach(columns -> {
            IntStream.range(0, columns.length).forEach(i ->{
                List<Integer> l = box.get(columns.length-1-i);
                l.add(columns[i]);
            });
        });

        return box.stream().map(this::toArray).toArray(i -> new int[box.size()][box.get(0).size()]);
    }

    //TODO List#toArrayを使いたい。。。
    int[] toArray(List<Integer> l){
        int[] array = new int[l.size()];

        IntStream.range(0, l.size())
                .forEach(i -> {
                    array[i] = l.get(i);
                });
        return array;
    }
}
