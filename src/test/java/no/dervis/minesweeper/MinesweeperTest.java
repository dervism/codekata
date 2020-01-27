package no.dervis.minesweeper;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MinesweeperTest {

    @Test
    void test4x4Field() throws IOException {

        String actual = new Minesweeper().play(TestData.acceptanceTest);

        assertEquals(TestData.acceptanceTestOutput, actual);
    }

    @Test
    void test1x1Field() throws IOException {

        String actual = new Minesweeper().play(TestData.m1x1);

        assertEquals(TestData.m1x1Output, actual);
    }

    @Test
    void test2x2Field() throws IOException {

        String actual = new Minesweeper().play(TestData.m2x2);

        assertEquals(TestData.m2x2Output, actual);
    }

    @Test
    void testThrowsExceptionOnWrongColLength() {
        assertThrows(RuntimeException.class, () -> new Minesweeper().play(TestData.wrongColLength) );
    }

    @Test
    void testThrowsExceptionOnWrongFieldSize() {
        assertThrows(RuntimeException.class, () -> new Minesweeper().play(TestData.wrongFieldSize) );
    }
}