package no.dervis.yatzy.game;

import no.dervis.yatzy.game.player.YatzyPlayer;
import no.dervis.yatzy.model.ScoreCard;
import org.junit.jupiter.api.Test;

import static no.dervis.yatzy.model.Category.FOUR;
import static no.dervis.yatzy.model.Category.ONE;

class YatzyPlayerTest {

    @Test
    void play() {

        YatzyPlayer player = new YatzyPlayer(12345678, true);
        player.play(new ScoreCard());
    }

    @Test
    void play2() {

        YatzyPlayer player = new YatzyPlayer(1437231842, true);
        player.play(ScoreCard.of(ONE, FOUR));
    }
}