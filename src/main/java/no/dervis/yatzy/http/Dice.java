package no.dervis.yatzy.http;

import java.util.List;

@FunctionalInterface
public interface Dice {

    List<Integer> roll(int n);

}
