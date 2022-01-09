package no.dervis.romannums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNums4Test {

    @Test
    void toRomanOnes() {
        RomanNums4 r = new RomanNums4();
        assertEquals("I", r.toRoman(1));
        assertEquals("II", r.toRoman(2));
        assertEquals("III", r.toRoman(3));
        assertEquals("IV", r.toRoman(4));
        assertEquals("V", r.toRoman(5));
        assertEquals("VI", r.toRoman(6));
        assertEquals("VII", r.toRoman(7));
        assertEquals("VIII", r.toRoman(8));
        assertEquals("IX", r.toRoman(9));
    }

    @Test
    void toRomanTens() {
        RomanNums4 r = new RomanNums4();
        assertEquals("XC", r.toRoman(90));
        assertEquals("L", r.toRoman(50));
        assertEquals("XL", r.toRoman(40));
        assertEquals("XLI", r.toRoman(41));

        assertEquals("XCIX", r.toRoman(99));
        assertEquals("XCVIII", r.toRoman(98));
        assertEquals("LXXVIII", r.toRoman(78));
        assertEquals("LIV", r.toRoman(54));
        assertEquals("LV", r.toRoman(55));
        assertEquals("XXXIX", r.toRoman(39));
        assertEquals("XI", r.toRoman(11));
        assertEquals("LXXXVI", r.toRoman(86));
        assertEquals("LXVII", r.toRoman(67));
        assertEquals("LXIV", r.toRoman(64));
        assertEquals("LX", r.toRoman(60));
        assertEquals("LXX", r.toRoman(70));
        assertEquals("LXXX", r.toRoman(80));
        assertEquals("XXX", r.toRoman(30));
        assertEquals("XX", r.toRoman(20));
        assertEquals("X", r.toRoman(10));
        assertEquals("XV", r.toRoman(15));
    }

    @Test
    void toRomanHundreds2() {
        RomanNums4 r = new RomanNums4();
        assertEquals("CM", r.toRoman(900));
        assertEquals("D", r.toRoman(500));
        assertEquals("CD", r.toRoman(400));
        assertEquals("C", r.toRoman(100));

        assertEquals("CI", r.toRoman(101));
        assertEquals("CCCIV", r.toRoman(304));
        assertEquals("CDIV", r.toRoman(404));
        assertEquals("CDL", r.toRoman(450));
        assertEquals("CDLVI", r.toRoman(456));
        assertEquals("CDXLVIII", r.toRoman(448));
        assertEquals("DLXXII", r.toRoman(572));
        assertEquals("DCXXXII", r.toRoman(632));
        assertEquals("DCCXXXIX", r.toRoman(739));
        assertEquals("DCCCLXXXVIII", r.toRoman(888));
        assertEquals("CMLXXXIX", r.toRoman(989));
        assertEquals("CMXCIX", r.toRoman(999));
    }

}