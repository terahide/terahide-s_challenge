package sample._8_interface;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreetingTest {
    @Test
    public void 日本語のtest(){
        // ここで皆さんが実装したクラスを使いインスタンスを作る想定
        // 英語と日本語の切り替えは今は考えなくてもよい
        Greeting sut = new JapaneseGreeting();
        String actual = sut.message();

        assertThat(actual, is("こんにちは"));
    }

    @Test
    public void 英語のtest(){
        // ここで皆さんが実装したクラスを使いインスタンスを作る想定
        // 英語と日本語の切り替えは今は考えなくてもよい
        Greeting sut = new EnglishGreeting();
        String actual = sut.message();

        assertThat(actual, is("Hello"));
    }
}
