package sample._5_file_io;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileCopy {
    public File copyWithLineNumber(File src)throws IOException {
        File f = File.createTempFile("xxx", ".txt");
        try(BufferedWriter writer =new BufferedWriter(new FileWriter(f))) {
            List<String> lines = Files.lines(src.toPath()).collect(Collectors.toList());
            IntStream.range(0, lines.size())
                    .mapToObj(i -> String.format("%d %s", i+1, lines.get(i)))
                    .forEach(l -> write(writer, l));
            return f;
        }
    }

    void write(BufferedWriter writer, String line){
        //TODO IOException をキャッチしたくない
        try {
            writer.write(line);
            writer.newLine();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
