package no.dervis.romannums;

public class RomanNums1 {

    public String toRoman(int number) {
        return toRoman(number, new StringBuilder());
    }

    /*
     * This is how to NOT solve this kata.
     *
     * Even though it works, it contains too many duplicates!
     *
     * For each base group the solution support, the more code
     * is needed to duplicate.
     */

    public String toRoman(int number, StringBuilder ret) {

        int base = (int) Math.pow(10, (int) Math.log10(number));

        if (number == 0) return ret.toString();

        if (base == 1) return toRoman(ones(number, ret), ret);
        if (base == 10) return toRoman(tens(number, ret), ret);
        if (base == 100) return toRoman(hundreds(number, ret), ret);

        return ret.toString();
    }

    /*
     * The pattern below continues.
     */

    public int hundreds(int n, StringBuilder ret) {
        int rest = n;

        if (rest >= 900) {
            ret.append("CM");
            rest -= 900;
        }

        if (rest >= 500) {
            ret.append("D");
            rest -= 500;
        }

        if (rest >= 400) {
            ret.append("CD");
            rest -= 400;
        }

        while (rest >= 100) {
            ret.append("C");
            rest -= 100;
        }

        return rest;
    }

    public int tens(int n, StringBuilder ret) {
        int rest = n;

        if (rest >= 90) {
            ret.append("XC");
            rest -= 90;
        }

        if (rest >= 50) {
            ret.append("L");
            rest -= 50;
        }

        if (rest >= 40) {
            ret.append("XL");
            rest -= 40;
        }

        while (rest >= 10) {
            ret.append("X");
            rest -= 10;
        }

        return rest;
    }

    public int ones(int n, StringBuilder ret) {
        int rest = n;

        if (rest >= 9) {
            ret.append("IX");
            rest -= 9;
        }

        if (rest >= 5) {
            ret.append("V");
            rest -= 5;
        }

        if (rest >= 4) {
            ret.append("IV");
            rest -= 4;
        }

        while (rest >= 1) {
            ret.append("I");
            rest--;
        }

        return rest;
    }

}
