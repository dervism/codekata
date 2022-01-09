package no.dervis.yatzy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {

    @Test
    void max() {
        assertTrue(Util.max(Arrays.asList(1, 1, 1)) == 1);
    }
}