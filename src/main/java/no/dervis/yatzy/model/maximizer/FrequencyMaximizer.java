package no.dervis.yatzy.model.maximizer;

import no.dervis.yatzy.model.Category;
import no.dervis.yatzy.model.ScoreCard;
import no.dervis.yatzy.model.ThrowState;

import java.util.Collections;

public class FrequencyMaximizer implements Maximizer {
    public FrequencyMaximizer() {
    }

    @Override
    public Category maximize(Category selectedCategory, ThrowState state, ScoreCard scoresheet) {
        if (selectedCategory == Category.SIX) {
            int freq6 = Collections.frequency(state.getDices(), 6);
            if (freq6 < 3) {
                return !scoresheet.hasCategory(Category.ONE) ? Category.ONE : !scoresheet.hasCategory(Category.TWO) ? Category.TWO :
                        !scoresheet.hasCategory(Category.THREE) ? Category.THREE : selectedCategory;
            }
        }

        if (selectedCategory == Category.FIVE) {
            int freq5 = Collections.frequency(state.getDices(), 5);
            if (freq5 < 2) {
                return !scoresheet.hasCategory(Category.ONE) ? Category.ONE : !scoresheet.hasCategory(Category.TWO) ? Category.TWO :
                        !scoresheet.hasCategory(Category.THREE) ? Category.THREE : selectedCategory;
            }
        }

        if (selectedCategory == Category.FOUR) {
            int freq4 = Collections.frequency(state.getDices(), 4);
            if (freq4 < 2) {
                return !scoresheet.hasCategory(Category.ONE) ? Category.ONE : !scoresheet.hasCategory(Category.TWO) ? Category.TWO :
                        !scoresheet.hasCategory(Category.THREE) ? Category.THREE : selectedCategory;
            }
        }

        return selectedCategory;
    }
}
