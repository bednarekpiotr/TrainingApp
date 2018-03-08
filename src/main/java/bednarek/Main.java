package bednarek;

import org.apache.log4j.Logger;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(FileUtils.class);
    public static void main(String[] args) {
    FileUtils fileUtils = new FileUtils();
    List<String> linesFromFile = fileUtils.readFromFileWithStream();
    List<Integer> values = new ArrayList<>();
    for (String lineFromFile:linesFromFile) {
        for(String temp:Arrays.asList(lineFromFile.split(","))) {
            try {
                values.add(Integer.valueOf(temp));
            } catch (NumberFormatException e) {
                LOGGER.info("Nie udało się sparsować wartości");
            }
        }
    }
    Collections.sort(values);
    fileUtils.writeToFile(values);

    }
}
