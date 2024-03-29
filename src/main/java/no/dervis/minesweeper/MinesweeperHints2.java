package no.dervis.minesweeper;

import java.util.function.BiPredicate;

public class MinesweeperHints2 {

    public static StringBuilder calc(StringBuilder field, int rows, int columns) {

        for (int i = 0; i < rows * columns; i++) {
            int mines = 0, row = i / columns, column = i % columns;

            int[][] dimensions = new int[][] {
                    {row - 1, column},
                    {row, column - 1},
                    {row, column + 1},
                    {row + 1 , column},

                    {row - 1 , column - 1},
                    {row + 1 , column + 1},
                    {row + 1 , column - 1},
                    {row - 1 , column + 1}
            };

            for (int[] dimension : dimensions) {
                if (isAMine(dimension, rows, columns, field)) mines++;
            }

            if (field.charAt(i) != '*') field.setCharAt(i, Character.forDigit(mines, 10));
        }

        return new StringBuilder(field.toString());
    }

    private static boolean isAMine(int[] dimention, int rows, int columns, StringBuilder field) {
        BiPredicate<Integer, Integer> p = (k, j) -> k >= 0 && k < j;
        return p.test(dimention[0], rows) && p.test(dimention[1], columns) && field.charAt(columns * dimention[0] + dimention[1]) == '*';
    }
}
