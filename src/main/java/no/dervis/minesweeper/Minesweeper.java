package no.dervis.minesweeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Minesweeper {

    public static final Logger log = LoggerFactory.getLogger(Minesweeper.class);

    public String play(String input) throws IOException {
        Predicate<Integer> sizeEval = n -> 0 < n && n <= 100;
        LineNumberReader reader = new LineNumberReader(new StringReader(input));
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        int fieldCount = 0;
        var regex = "^([-+]?\\d+)\\s([-+]?\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        while (!(line = reader.readLine()).equals("0 0")) {
            var matcher = pattern.matcher(line);
            if (matcher.matches()){
                //parse header
                if (fieldCount > 0) stringBuilder.append(System.lineSeparator()).append(System.lineSeparator());
                stringBuilder.append("Field #").append(++fieldCount).append(':').append(System.lineSeparator());

                // matrix size
                int rows = Integer.parseInt(matcher.group(1));
                int columns = Integer.parseInt(matcher.group(2));
                if (!(sizeEval.test(rows) && sizeEval.test(columns)))
                    throw new RuntimeException("Line " + reader.getLineNumber() + " is out of bounds (0 < rows,columns <= 100)");

                log.debug("Field header: " + rows + "," + columns);
                StringBuilder field = readField(reader, rows, columns);

                StringBuilder updated = MinesweeperHints2.calc(field, rows, columns);

                for (int i = 0; i < rows*columns; i++) {
                    if (i % columns == 0 && i > 0) stringBuilder.append(System.lineSeparator());
                    stringBuilder.append(updated.charAt(i));
                }
            }
        }

        stringBuilder.append(System.lineSeparator());

        return stringBuilder.toString();
    }

    public StringBuilder readField(LineNumberReader r, int n, int m) throws IOException {
        int rowIndex = 0;
        StringBuilder field = new StringBuilder();
        while (rowIndex < n) {
            var col = r.readLine().trim();
            if (col.length() == m) field.append(col);
            else throw new RuntimeException("Line " + r.getLineNumber() + " has wrong length.");
            rowIndex++;
        }
        return field;
    }

}
