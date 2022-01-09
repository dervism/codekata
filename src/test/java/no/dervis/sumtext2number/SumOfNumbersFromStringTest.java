package no.dervis.sumtext2number;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

class SumOfNumbersFromStringTest {

    @Test
    void sum() {
        try {
            String numbers = Files.readString(Path.of(this.getClass().getResource("/tall.txt").toURI()));
            System.out.println(SumOfNumbersFromString.sum(numbers));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}