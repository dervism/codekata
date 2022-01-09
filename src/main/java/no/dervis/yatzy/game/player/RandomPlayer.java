package no.dervis.yatzy.game.player;

import no.dervis.yatzy.model.Category;
import no.dervis.yatzy.model.ScoreCard;
import no.dervis.yatzy.model.ThrowState;
import no.dervis.yatzy.model.selection.RandomSelection;
import no.dervis.yatzy.model.selection.SelectionParams;

import java.util.Optional;

public class RandomPlayer extends YatzyPlayer {

    public RandomPlayer() {}

    public RandomPlayer(long seed, boolean log) {
        super(seed, log);
    }

    @Override
    protected Optional<Category> selectCategory(ScoreCard scoresheet, ThrowState state) {
        return new RandomSelection(new SelectionParams(state.getDices(), scoresheet)).select();
    }
}
