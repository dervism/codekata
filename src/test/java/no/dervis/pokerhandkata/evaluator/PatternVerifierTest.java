package no.dervis.pokerhandkata.evaluator;

import no.dervis.pokerhandkata.domain.Card;
import no.dervis.pokerhandkata.domain.CardGroup;
import no.dervis.pokerhandkata.domain.CardType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Set;

import static no.dervis.pokerhandkata.domain.CardType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternVerifierTest implements CardUtils{

    @Test
    void groupByTypeAndGroupCount2() {
        Card[] hand = {
                clubs(TWO),
                clubs(THREE),
                diamonds(THREE),
                hearts(FIVE),
                spades(FIVE),
                diamonds(FIVE)
        };

        Map<CardType, Set<CardGroup>> map = PatternVerifier.groupByTypeAndGroupCount(hand);
        System.out.println(map);

        assertEquals(1, map.get(TWO).size());
        assertEquals(2, map.get(THREE).size());
        assertEquals(3, map.get(FIVE).size());

        map = PatternVerifier.groupByTypeAndGroupCount2(hand);
        System.out.println(map);

        assertEquals(1, map.get(TWO).size());
        assertEquals(2, map.get(THREE).size());
        assertEquals(3, map.get(FIVE).size());
    }

    @Test
    void name() {
        Period p = Period.between(LocalDate.now(), LocalDate.now().plusDays(10));
        
    }
}