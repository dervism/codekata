package no.dervis.minesweeper;

public class TestData {

    public static final String acceptanceTest =
            """
            4 4
            *...
            ....
            .*..
            ....
            3 5
            **...
            .....
            .*...
            0 0
            """;

    public static final String acceptanceTestOutput =
            """
            Field #1:
            *100
            2210
            1*10
            1110

            Field #2:
            **100
            33200
            1*100
            """;

    public static final String m1x1 = """
            1 1
            .
            0 0
            """;

    public static final String m1x1Output = """
            Field #1:
            0
            """;

    public static final String m1x2 = """
            1 2
            *.
            0 0
            """;

    public static final String m1x2Output = """
            Field #1:
            *1
            """;

    public static final String m2x2 = """
            2 2
            *.
            ..
            0 0
            """;

    public static final String m2x2Output = """
            Field #1:
            *1
            11
            """;

    //
    // Problems
    //

    public static final String wrongColLength = """
            1 2
            *
            0 0
            """;

    public static final String wrongFieldSize = """
            1 101
            *
            0 0
            """;

    public static final String rowColStr = """
            *...
            ....
            ....
            """;
}
