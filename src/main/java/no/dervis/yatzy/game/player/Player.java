package no.dervis.yatzy.game.player;

import no.dervis.yatzy.model.ScoreCard;
import no.dervis.yatzy.model.ThrowState;

import java.util.List;

public interface Player {

    List<Integer> throwDice(int numberOfDice);

    ThrowState play(ScoreCard scoresheet);

}
