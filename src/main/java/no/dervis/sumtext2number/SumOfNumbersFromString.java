package no.dervis.sumtext2number;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SumOfNumbersFromString {

    public static final String TI = "ti";
    public static final String TJUE = "tjue";
    public static final String TRETTI = "tretti";
    public static final String FORTI = "førti";
    public static final String FEMTI = "femti";

    record Pair(String name, int number) {
        static Pair of(String name, int number) {
            return new Pair(name, number);
        }
    }

    private static List<Pair> makeTens(String group) {
        int sum = switch (group) {
            case TI -> 10;
            case TJUE -> 20;
            case TRETTI -> 30;
            case FORTI -> 40;
            case FEMTI -> 50;
            default -> throw new IllegalArgumentException();
        };

        final var prefix = sum == 10 ? "" : group;
        final int adding = sum == 10 ? 0 : sum;
        final int index  = sum == 10 ? 10 : 9;

        return IntStream.iterate(index, k -> k - 1).limit(10)
            .mapToObj(value -> switch (value) {
                    case 9 -> Pair.of(prefix + "ni", adding + 9);
                    case 8 -> Pair.of(prefix + "åtte", adding + 8);
                    case 7 -> Pair.of(prefix + "sju", adding + 7);
                    case 6 -> Pair.of(prefix + "seks", adding + 6);
                    case 5 -> Pair.of(prefix + "fem", adding + 5);
                    case 4 -> Pair.of(prefix + "fire", adding + 4);
                    case 3 -> Pair.of(prefix + "tre", adding + 3);
                    case 2 -> Pair.of(prefix + "to", adding + 2);
                    case 1 -> Pair.of(prefix + "en", adding + 1);
                    case 0, 10 -> Pair.of(group, sum);
                    default -> throw new IllegalArgumentException();
                })
                .collect(Collectors.toList());
    }

    public static LinkedList<Pair> pairs() {
        return new LinkedList<>() {{
            add(Pair.of("nitten",19));
            add(Pair.of("atten",18));
            add(Pair.of("sytten",17));
            add(Pair.of("seksten",16));
            add(Pair.of("femten",15));
            add(Pair.of("fjorten",14));
            add(Pair.of("tretten",13));
            add(Pair.of("tolv",12));
            add(Pair.of("elleve",11));
        }};
    }

    public static double sum(String s){
        LinkedList<Pair> pairs = pairs();
        pairs.addAll(pairs.size() , makeTens(TI));
        pairs.add(0, Pair.of(TJUE, 20));
        pairs.add(0, Pair.of(TRETTI, 30));
        pairs.add(0, Pair.of(FORTI, 40));
        pairs.add(0, Pair.of(FEMTI, 50));
        double sum = 0;

        for (Pair pair : pairs) {
            while (s.contains(pair.name)) {
                sum += pair.number;
                s = s.replaceFirst(pair.name, "");
            }
        }

        return sum;
    }

    public static double sum2(String s){
        LinkedList<Pair> pairs = pairs();

        pairs.addAll(pairs.size() , makeTens(TI));
        pairs.addAll(0, makeTens(TJUE));
        pairs.addAll(0, makeTens(TRETTI));
        pairs.addAll(0, makeTens(FORTI));
        pairs.add(0, Pair.of(FEMTI, 50));
        double sum = 0;

        for (Pair pair : pairs) {
            while (s.contains(pair.name)) {
                sum += pair.number;
                s = s.replaceFirst(pair.name, "");
            }
        }

        System.out.println(s);

        return sum;
    }


}
