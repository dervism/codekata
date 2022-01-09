package no.dervis.romannums;

public class RomanNums6 {

    final int[] arr = new int[] {900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final String[] str = new String[] {"CM", "D", "CD", "C", "XC", "L", "XL", "X" ,"IX", "V", "IV", "I"};

    public String toRoman(int number, StringBuilder romanText) {
        if (number <= 0) return romanText.toString();
        int index = 0;
        while (arr[index] > number) index++;
        romanText.append(str[index]);
        return toRoman(number - arr[index], romanText);
    }
}
