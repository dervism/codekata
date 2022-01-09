package no.dervis.yatzy.game;

import no.dervis.yatzy.game.player.RandomPlayer;
import no.dervis.yatzy.game.player.YatzyPlayer;
import org.junit.jupiter.api.Test;

class YatzyTest {

    @Test
    void play() {
        Game player = new Yatzy(new YatzyPlayer());
        player.play();

        System.out.println();

        Game random = new Yatzy(new RandomPlayer());
        random.play();
    }
}