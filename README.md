# はじめに
このリポジトリは社員のプログラム研修のためのものです


# 1 初級 Hello World
Hello World! と画面に表示するプログラムを書いてください。言語は問いません。

---
# 1 初級 int
以下のプログラムを実行すると画面に何が表示されますか？

    public static void main(String[] args){
      int i = 1;
      calc(i);
      System.out.println("i="+ i);
    }
    
    public static void calc(int i){
      i = i * 10;
    }

---
# 5 中級 Collection Framework
この問題はJava8でプログラムを作成してください
以下のリストがある。

    ["a", "b", "c", "d"]


1. このリストの要素をランダムに複製し、要素数を100個に増やしてください
2. 1. で作成したリストの要素でグループした数を表示してください

2.の出力結果のイメージ

    "a" 32回
    "b" 17回
    "c" 26回
    "d" 25回

---
# 5 中級 FizzBuzz
  
  FizzBuzzの仕様
  
      1-100の正の整数を用いる
      数字を渡すとその数字を表示する。
      ただし、
      - 3の倍数はFizzと表示する
      - 5の倍数はBuzzと表示する
      - 3と5の倍数はFizzBuzzと表示する
  
  FizzBuzzの仕様に従い1-100の数字を用いた出力結果を表示するプログラムを作成してください。ただし、言語はJava8とする。

---
# 5 中級 ファイルIO
  あるテキストファイルAの内容を読み込み、一時ファイルへ出力するプログラム(Java8)を以下の条件に従い作成してください。なお一時ファイルのファイル名は任意とする。
  
  条件
  
  - 行の先頭に行番号を足して出力すること
  - strem、writerのclose()メソッドを明示的に利用しないこと
  
  テキストファイルAの内容
  
      朝起きたら天気がよかった
      気分がよかったから朝からラーメンを食べた
      朝のラーメン屋は空いていてお客は私一人だけだった
  
  
  ----------
  
  出力後の一時ファイルのイメージ例
  
      1 朝起きたら天気がよかった
      2 気分がよかったから朝からラーメンを食べた
      3 朝のラーメン屋は空いていてお客は私一人だけだった

---
# 9 上級 Stream
以下のような二次元配列があったとする

    1,2,3
    4,5,6
    7,8,9

これを左へ90度回転させるとこのようになる

    3,6,9
    2,5,8
    1,4,7

このように二次元配列を左へ90度回転させてそれを出力するプログラムを作成してください。
ただし、言語はJava8を利用すること。また、forとwhileを使用しないこと。

---
# 9 上級 よくあるバグ
  以下のJava8のプログラムは本日の日付を1万回表示するためのものである。
  ところが、致命的なバグが３つ含まれている。
  これらを解消して正しいプログラムに修正してください。
  ※前提： 実行する日付は Line:14 で指定している
  
  
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
                      .filter(s -> s == "2021.04.20") // 前提：今日は 2021.04.20 とする
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

---
# 9 上級 インタフェース
以下のインタフェースは挨拶を取得するインタフェースである
これを英語の挨拶を返すものと日本語の挨拶を返すものの２つを実装してください。なお使用する言語はJava8とする


    interface Greeting{
      String message();
    }

       
以下上記のインタフェースを使用する想定のコード


    public void do(){
        // ここで皆さんが実装したクラスを使いインスタンスを作る想定
        // 英語と日本語の切り替えは今は考えなくてもよい
        Greeting greeting = new XXXXXXXX(); 
    
        System.out.println(greeting.message());
    }
