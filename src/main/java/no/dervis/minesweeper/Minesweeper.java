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
        Predicate<Integer> predicate = n -> 0 < n && n <= 100;
        LineNumberReader r = new LineNumberReader(new StringReader(input));
        StringBuilder b = new StringBuilder();
        String line = "";
        int fieldCount = 0;
        var regex = "^([-+]?\\d+)\\s([-+]?\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        while (!(line = r.readLine()).equals("0 0")) {
            var matcher = pattern.matcher(line);
            if (matcher.matches()){
                //parse header
                if (fieldCount > 0) b.append(System.lineSeparator()).append(System.lineSeparator());
                b.append("Field #").append(++fieldCount).append(':').append(System.lineSeparator());
                int n = Integer.parseInt(matcher.group(1));
                int m = Integer.parseInt(matcher.group(2));
                if (!(predicate.test(n) && predicate.test(m)))
                    throw new RuntimeException("Line " + r.getLineNumber() + " is out of bounds (0 < n,m <= 100)");
                log.debug("Found field header: " + n + "," + m);

                // read field
                StringBuilder field = readField(r, n, m);
                //StringBuilder updated = calc(field, n, m);

                for (int i = 0; i < n*m; i++) {
                    if (i % m == 0 && i > 0) b.append(System.lineSeparator());
                    b.append(field.charAt(i));
                }

            }
        }

        return b.toString();
    }

    /**
     * Alternative first line split.
     * int n = splitAndRead(line)[0];
     * int m = splitAndRead(line)[1];
     *
     * Note: Be aware of possible errors in formatting!
     */
    public int[] splitAndRead(String line) {
        String[] split = line.split(" ");
        if (split == null || split.length == 0) throw new RuntimeException();
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        return new int[] {n, m};
    }

    private StringBuilder readField(LineNumberReader r, int n, int m) throws IOException {
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
