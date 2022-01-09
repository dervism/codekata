package no.dervis.yatzy.model.maximizer;

import no.dervis.yatzy.model.Category;
import no.dervis.yatzy.model.ScoreCard;
import no.dervis.yatzy.model.ThrowState;

@FunctionalInterface
public interface Maximizer {
    Category maximize(Category selectedCategory, ThrowState state, ScoreCard scoresheet);
}
