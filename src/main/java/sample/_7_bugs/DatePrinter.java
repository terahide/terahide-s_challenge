package sample._7_bugs;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatePrinter {

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        List<Thread> l = IntStream.range(0,10000)
                .filter(s -> s == "2021.05.11") // 前提：今日は 2021.05.11 とする
                .mapToObj(DatePrinter::dateFormat)
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

    static String dateFormat(int i){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        return formatter.format(new Date());
    }

    static void joinThread(Thread t){
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}