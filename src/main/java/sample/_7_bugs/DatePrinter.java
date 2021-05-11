package sample._7_bugs;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatePrinter {
    final static StringBuffer sb = new StringBuffer();
    final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

    public static void main(String[] args) throws Exception{
        List<Thread> l = IntStream.range(0,10000)
                .mapToObj( i -> formatter.format(new Date()) )
                .filter(s -> s == "2021.05.11") // 前提：今日は 2021.05.11 とする
                .map( s -> new Thread(()->{
                    sb.append(s);
                    sb.append("\n");
                }))
                .collect(Collectors.toList());

        l.forEach(Thread::start);
        l.forEach(DatePrinter::joinThread);

        System.out.println(sb);
        System.out.println("finish");
    }

    static void joinThread(Thread t){
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}