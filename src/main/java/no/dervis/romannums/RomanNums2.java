package no.dervis.romannums;

public class RomanNums2 {

    final String[] arr = new String[]{"9", "5", "4", "1", "IX", "V", "IV", "I", "XC", "L", "XL", "X", "CM", "D", "CD", "C"};

    public String toRoman(int number) {
        return toRoman(number, new StringBuilder());
    }

    public String toRoman(int number, StringBuilder romanText) {
        if (number == 0) return romanText.toString();
        int base = (int) Math.pow(10, (int) Math.log10(number)); // log10 is Java's common logarithm

        for (int i = 0; i < 4; i++) {
            while (number >= (Integer.parseInt(arr[i])*base)) {
                romanText.append( arr[(int) (4 + i + (Math.log10(base) * 4))] );
                number -= (Integer.parseInt(arr[i])*base);
            }
        }

        return toRoman(number, romanText);
    }
}
