package no.dervis.pokerhandkata.simulator;

import no.dervis.pokerhandkata.domain.Hand;
import no.dervis.pokerhandkata.domain.PokerCardDeck;
import no.dervis.pokerhandkata.domain.PokerPatternType;
import no.dervis.pokerhandkata.evaluator.PokerPatternEvaluator;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * PokerHandSimulator
 *
 * When executed, you'll get an output such as
 * >>> 1.13 sec
 * High Card 245586(223688) (49.117%)
 * One Pair 230344(220457) (46.069%)
 * Three Of a Kind 11825(11676) (2.365%)
 * Two Pairs 8430(8236) (1.686%)
 * Straight 1731(1574) (0.346%)
 * Flush 1063(989) (0.213%)
 * House 838(833) (0.168%)
 * Four Of a Kind 174(174) (0.035%)
 * Straight Flush 8(5) (0.002%)
 * Royal Flush 1(1) (0%)
 *
 * Output:
 * Poker-pattern x1 (x2) (x3), where
 *
 * x1 = number of times a hand is drawn
 * x2 = number of unique hands
 * x3 = precentage of this rank in the set.
 *
 * @author Dervis M.
 * @version 0.1
 */

public class PokerHandSimulator implements Runnable {
    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final AtomicBoolean stopped = new AtomicBoolean(true);
    private final int numTrials = 500000;

    private EnumMap<PokerPatternType, Integer> patterns;
    private EnumMap<PokerPatternType, Set<String>> uniques;

    @Override
    public void run() {
        Progressbar progressbar = new Progressbar();
        PokerCardDeck cardDeck = createPokerCardDeck();
        createPatternContainers();

        int numDealt = 0;

        running.set(true);
        stopped.set(false);

        progressbar.start();

        while (!Thread.interrupted() && isRunning() && numDealt < numTrials) {
            Hand hand = cardDeck.getHand(5);
            PokerPatternType pattern = PokerPatternEvaluator.getPokerPattern(hand.sort(), false);

            patterns.merge(pattern, 1, Integer::sum);
            uniques.get(pattern).add(hand.toString());

            numDealt++;
        }

        progressbar.stop();

        TreeSet<Map.Entry<PokerPatternType, Integer>> set = new TreeSet<>(Map.Entry.<PokerPatternType, Integer>comparingByValue().reversed());
        set.addAll(patterns.entrySet());

        DecimalFormat des = new DecimalFormat("##.###");
        for (Map.Entry<PokerPatternType, Integer> entry : set) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() +
                    "(" + uniques.get(entry.getKey()).size() + ")" +
                    " (" + (des.format(((entry.getValue() / (float) numTrials)) * 100)) + "%) ");
        }

        running.set(false);
        stopped.set(true);
    }

    private void createPatternContainers() {
        patterns = new EnumMap<>(PokerPatternType.class);
        uniques = new EnumMap<>(PokerPatternType.class);

        for (PokerPatternType type : PokerPatternType.values()) {
            patterns.put(type, 0);
            uniques.put(type, new HashSet<>());
        }
    }

    private PokerCardDeck createPokerCardDeck() {
        PokerCardDeck cardDeck = new PokerCardDeck();
        cardDeck.create();
        cardDeck.shuffle();
        cardDeck.secureShuffle();
        return cardDeck;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    boolean isRunning() {
        return running.get();
    }

}
