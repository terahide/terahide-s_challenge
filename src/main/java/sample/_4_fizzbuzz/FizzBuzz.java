package sample._4_fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args){
        FizzBuzz me = new FizzBuzz();
        IntStream.range(1,100+1)
                .mapToObj(me::stringify)
                .forEach(System.out::println);
    }

    public String stringify(int i){
        if( i % (3 * 5) == 0)return "FizzBuzz";
        if( i % 3 == 0)return "Fizz";
        if( i % 5 == 0)return "Buzz";
        return String.valueOf(i);
    }
}
