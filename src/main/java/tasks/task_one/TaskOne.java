package tasks.task_one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TaskOne {

    public static void main(String[] args) {
        try {
            System.out.println("Words that start with 'O' case insensitive:");
            String str = Files.readString(Path.of("input.txt"));
            List<String> words = List.of(str.split("[ !\"\\\\#$%&'()*+—,-./:;<=>?@[\\\\]^_`{|}~]+"));
            List<String> result = words.stream().filter(x -> x.startsWith("o") || x.startsWith("O")).distinct().collect(Collectors.toList());
            result.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
