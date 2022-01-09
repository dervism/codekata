package no.dervis.romannums;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNums6Test {
    
    Supplier<StringBuilder> sb = StringBuilder::new;

    @Test
    void toRomanOnes() {
        RomanNums6 r = new RomanNums6();
        assertEquals("I", r.toRoman(1, sb.get()));
        assertEquals("II", r.toRoman(2, sb.get()));
        assertEquals("III", r.toRoman(3, sb.get()));
        assertEquals("IV", r.toRoman(4, sb.get()));
        assertEquals("V", r.toRoman(5, sb.get()));
        assertEquals("VI", r.toRoman(6, sb.get()));
        assertEquals("VII", r.toRoman(7, sb.get()));
        assertEquals("VIII", r.toRoman(8, sb.get()));
        assertEquals("IX", r.toRoman(9, sb.get()));
    }

    @Test
    void toRomanTens() {
        RomanNums6 r = new RomanNums6();
        assertEquals("XC", r.toRoman(90, sb.get()));
        assertEquals("L", r.toRoman(50, sb.get()));
        assertEquals("XL", r.toRoman(40, sb.get()));
        assertEquals("XLI", r.toRoman(41, sb.get()));

        assertEquals("XCIX", r.toRoman(99, sb.get()));
        assertEquals("XCVIII", r.toRoman(98, sb.get()));
        assertEquals("LXXVIII", r.toRoman(78, sb.get()));
        assertEquals("LIV", r.toRoman(54, sb.get()));
        assertEquals("LV", r.toRoman(55, sb.get()));
        assertEquals("XXXIX", r.toRoman(39, sb.get()));
        assertEquals("XI", r.toRoman(11, sb.get()));
        assertEquals("LXXXVI", r.toRoman(86, sb.get()));
        assertEquals("LXVII", r.toRoman(67, sb.get()));
        assertEquals("LXIV", r.toRoman(64, sb.get()));
        assertEquals("LX", r.toRoman(60, sb.get()));
        assertEquals("LXX", r.toRoman(70, sb.get()));
        assertEquals("LXXX", r.toRoman(80, sb.get()));
        assertEquals("XXX", r.toRoman(30, sb.get()));
        assertEquals("XX", r.toRoman(20, sb.get()));
        assertEquals("X", r.toRoman(10, sb.get()));
        assertEquals("XV", r.toRoman(15, sb.get()));
    }

    @Test
    void toRomanHundreds2() {
        RomanNums6 r = new RomanNums6();
        assertEquals("CM", r.toRoman(900, sb.get()));
        assertEquals("D", r.toRoman(500, sb.get()));
        assertEquals("CD", r.toRoman(400, sb.get()));
        assertEquals("C", r.toRoman(100, sb.get()));

        assertEquals("CI", r.toRoman(101, sb.get()));
        assertEquals("CCCIV", r.toRoman(304, sb.get()));
        assertEquals("CDIV", r.toRoman(404, sb.get()));
        assertEquals("CDL", r.toRoman(450, sb.get()));
        assertEquals("CDLVI", r.toRoman(456, sb.get()));
        assertEquals("CDXLVIII", r.toRoman(448, sb.get()));
        assertEquals("DLXXII", r.toRoman(572, sb.get()));
        assertEquals("DCXXXII", r.toRoman(632, sb.get()));
        assertEquals("DCCXXXIX", r.toRoman(739, sb.get()));
        assertEquals("DCCCLXXXVIII", r.toRoman(888, sb.get()));
        assertEquals("CMLXXXIX", r.toRoman(989, sb.get()));
        assertEquals("CMXCIX", r.toRoman(999, sb.get()));
    }

}