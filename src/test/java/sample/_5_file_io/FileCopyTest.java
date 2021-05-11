package sample._5_file_io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileCopyTest {
    @Test
    public void test() throws IOException {
        FileCopy sut = new FileCopy();

        File out = sut.copyWithLineNumber(FileSystems.getDefault().getPath("./src/test/java/sample/_5_file_io/input.txt").toFile());
        List<String> lines = read(out);
        assertThat(lines.size(), is(3));
        assertThat(lines.get(0), is("1 朝起きたら天気がよかった"));
        assertThat(lines.get(1), is("2 気分がよかったから朝からラーメンを食べた"));
        assertThat(lines.get(2), is("3 朝のラーメン屋は空いていてお客は私一人だけだった"));
    }

    List<String> read(File f)throws IOException{
        return Files.lines(f.toPath()).collect(Collectors.toList());
    }
}
