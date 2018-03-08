package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;

public class FileUtils {
    private static final Logger LOGGER = Logger.getLogger(FileUtils.class);
    String input = "src/main/resources/input.txt";
    String output = "src/main/resources/output.txt";

    public  List<String> readFromFileWithStream() {
        try (Stream<String> stream = Files.lines(Paths.get(input))) {
            return stream.collect(Collectors.toList());

        } catch (IOException e) {
            LOGGER.info("Wystąpił błąd przy odczycie pliku");
        }

        return Collections.emptyList();
    }

    public void writeToFile(List<Integer> list) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(output)))
        {
            for (Integer integer:list) {
                writer.write(integer.toString());
                writer.write(',');
            }
        } catch (IOException e) {
            LOGGER.info("Wystapil blad przy zapisie");
        }
    }
}
