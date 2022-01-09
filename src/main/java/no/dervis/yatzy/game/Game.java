package no.dervis.yatzy.game;

import no.dervis.yatzy.model.Category;

import java.util.Map;

public interface Game {

    Map<Category, Double> play();

    double score();
}
