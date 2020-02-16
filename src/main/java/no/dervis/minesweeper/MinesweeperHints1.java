package no.dervis.minesweeper;

import java.util.function.BiPredicate;

public class MinesweeperHints1 {

    public static StringBuilder calc(StringBuilder field, int rows, int columns) {
        StringBuilder builder = new StringBuilder(field);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int mines = 0, index = columns * row + column;

                if (isMine(row - 1, column, rows, columns, field)) mines++;
                if (isMine(row, column - 1, rows, columns, field)) mines++;
                if (isMine(row, column + 1, rows, columns, field)) mines++;
                if (isMine(row + 1 , column, rows, columns, field)) mines++;

                if (isMine(row - 1 , column - 1, rows, columns, field)) mines++;
                if (isMine(row + 1 , column + 1, rows, columns, field)) mines++;
                if (isMine(row + 1 , column - 1, rows, columns, field)) mines++;
                if (isMine(row - 1 , column + 1, rows, columns, field)) mines++;

                if (field.charAt(index) != '*') builder.setCharAt(index, Character.forDigit(mines, 10));
            }
        }

        return builder;
    }

    private static boolean isMine(int row, int column, int rows, int columns, StringBuilder field) {
        BiPredicate<Integer, Integer> p = (k, j) -> k >= 0 && k < j;
        return p.test(column, columns) && p.test(row, rows) && field.charAt(columns * row + column) == '*';
    }

}
