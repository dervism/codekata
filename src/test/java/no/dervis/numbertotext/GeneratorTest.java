package no.dervis.numbertotext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GeneratorTest {

    private Generator generator;

    @BeforeEach
    public void setup() {
        generator = new Generator();
    }

    @Test
    public void testMillions() throws Exception {
        assertEquals(generator.millions(1_000_000), "en million");
        assertEquals(generator.convert(1_000_000), "en million");


        assertEquals(generator.millions(1_250_300), "en million to hundre og femti tusen tre hundre");
        assertEquals(generator.millions(1_250_301), "en million to hundre og femti tusen tre hundre og en");
        assertEquals(generator.millions(1_250_315), "en million to hundre og femti tusen tre hundre og femten");
        assertEquals(generator.millions(1_851_815), "en million åtte hundre og femtien tusen åtte hundre og femten");
        assertEquals(generator.convert(1_851_815), "en million åtte hundre og femtien tusen åtte hundre og femten");


        assertEquals(generator.millions(2_000_000), "to millioner");
        assertEquals(generator.millions(2_000_001), "to millioner og en");
        assertEquals(generator.millions(2_000_010), "to millioner og ti");
        assertEquals(generator.millions(2_000_011), "to millioner og ellve");

        assertEquals(generator.millions(2_000_021), "to millioner og tjueen");
        assertEquals(generator.convert(2_000_021), "to millioner og tjueen");

        assertEquals(generator.millions(12_000_000), "tolv millioner");
        assertEquals(generator.millions(12_000_001), "tolv millioner og en");
        assertEquals(generator.millions(12_000_010), "tolv millioner og ti");

        assertEquals(generator.millions(12_000_100), "tolv millioner ett hundre");
        assertEquals(generator.convert(12_000_100), "tolv millioner ett hundre");

        assertEquals(generator.millions(12_001_000), "tolv millioner ett tusen");
        assertEquals(generator.millions(12_010_000), "tolv millioner ti tusen");
        assertEquals(generator.millions(12_100_000), "tolv millioner ett hundre tusen");
        assertEquals(generator.millions(120_000_000), "ett hundre og tjue millioner");
        assertEquals(generator.millions(120_000_001), "ett hundre og tjue millioner og en");

        assertEquals(generator.millions(999_000_001), "ni hundre og nittini millioner og en");
        assertEquals(generator.convert(999_000_001), "ni hundre og nittini millioner og en");

        // Integer.MAX_VALUE
        assertEquals(generator.millions(2146_999_999), "to tusen ett hundre og førtiseks millioner ni hundre og nittini tusen ni hundre og nittini");
        assertEquals(generator.convert(2146_999_999), "to tusen ett hundre og førtiseks millioner ni hundre og nittini tusen ni hundre og nittini");
    }

    @Test
    public void testHundredThoundsands() throws Exception {
        assertEquals(generator.hundreds_thoundsands(100_000), "ett hundre tusen");
        assertEquals(generator.convert(100_000), "ett hundre tusen");

        assertEquals(generator.hundreds_thoundsands(100_001), "ett hundre tusen og en");
        assertEquals(generator.hundreds_thoundsands(200_000), "to hundre tusen");
        assertEquals(generator.hundreds_thoundsands(102_000), "ett hundre og to tusen");
        assertEquals(generator.hundreds_thoundsands(202_000), "to hundre og to tusen");
        assertEquals(generator.hundreds_thoundsands(202_001), "to hundre og to tusen og en");
        assertEquals(generator.hundreds_thoundsands(398_000), "tre hundre og nittiåtte tusen");
        assertEquals(generator.hundreds_thoundsands(398_010), "tre hundre og nittiåtte tusen og ti");
        assertEquals(generator.hundreds_thoundsands(398_100), "tre hundre og nittiåtte tusen ett hundre");

        assertEquals(generator.hundreds_thoundsands(589_370), "fem hundre og åttini tusen tre hundre og sytti");
        assertEquals(generator.hundreds_thoundsands(589_371), "fem hundre og åttini tusen tre hundre og syttien");
        assertEquals(generator.hundreds_thoundsands(600_371), "seks hundre tusen tre hundre og syttien");
        assertEquals(generator.convert(600_371), "seks hundre tusen tre hundre og syttien");

        assertEquals(generator.hundreds_thoundsands(700_701), "syv hundre tusen syv hundre og en");
        assertEquals(generator.hundreds_thoundsands(999_990), "ni hundre og nittini tusen ni hundre og nitti");
        assertEquals(generator.convert(999_990), "ni hundre og nittini tusen ni hundre og nitti");
    }

    @Test
    public void testTensThousands() {
        assertEquals(generator.convert(10_000), "ti tusen");
        assertEquals(generator.convert(10_001), "ti tusen og en");
        assertEquals(generator.convert(10_101), "ti tusen ett hundre og en");
        assertEquals(generator.convert(20_000), "tjue tusen");
        assertEquals(generator.convert(20_100), "tjue tusen ett hundre");
        assertEquals(generator.convert(20_001), "tjue tusen og en");
        assertEquals(generator.convert(24_679), "tjuefire tusen seks hundre og syttini");
        assertEquals(generator.convert(64_234), "sekstifire tusen to hundre og trettifire");
        assertEquals(generator.convert(99_000), "nittini tusen");
        assertEquals(generator.convert(99_001), "nittini tusen og en");
        assertEquals(generator.convert(99_010), "nittini tusen og ti");
    }

    @Test
    public void testThoundsands() throws Exception {
        assertEquals(generator.thoundsands(1000), "ett tusen");
        assertEquals(generator.convert(1000), "ett tusen");

        assertEquals(generator.thoundsands(2000), "to tusen");
        assertEquals(generator.thoundsands(1101), "ett tusen ett hundre og en");
        assertEquals(generator.thoundsands(2101), "to tusen ett hundre og en");
        assertEquals(generator.thoundsands(1001), "ett tusen og en");
        assertEquals(generator.thoundsands(2001), "to tusen og en");
        assertEquals(generator.thoundsands(2010), "to tusen og ti");
        assertEquals(generator.thoundsands(2100), "to tusen ett hundre");
        assertEquals(generator.thoundsands(3456), "tre tusen fire hundre og femtiseks");

        assertEquals(generator.thoundsands(9999), "ni tusen ni hundre og nittini");
        assertEquals(generator.convert(9999), "ni tusen ni hundre og nittini");
    }

    @Test
    public void testHundreds() throws Exception {
        assertEquals(generator.hundreds(100), "ett hundre");
        assertEquals(generator.convert(100), "ett hundre");

        assertEquals(generator.hundreds(122), "ett hundre og tjueto");
        assertEquals(generator.hundreds(112), "ett hundre og tolv");
        assertEquals(generator.hundreds(101), "ett hundre og en");
        assertEquals(generator.hundreds(200), "to hundre");
        assertEquals(generator.hundreds(222), "to hundre og tjueto");
        assertEquals(generator.hundreds(201), "to hundre og en");

        assertEquals(generator.hundreds(356), "tre hundre og femtiseks");
        assertEquals(generator.hundreds(370), "tre hundre og sytti");
        assertEquals(generator.convert(370), "tre hundre og sytti");
    }

    @Test
    public void testTens() throws Exception {
        assertEquals(generator.tens(0), "null");
        assertEquals(generator.tens(1), "en");
        assertEquals(generator.tens(2), "to");
        assertEquals(generator.convert(2), "to");

        assertEquals(generator.tens(12), "tolv");
        assertEquals(generator.tens(22), "tjueto");
        assertEquals(generator.tens(99), "nittini");
        assertEquals(generator.tens(30), "tretti");
        assertEquals(generator.tens(70), "sytti");

        assertEquals(generator.tens(74), "syttifire");
        assertEquals(generator.convert(74), "syttifire");
    }

}