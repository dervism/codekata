package no.dervis.yatzy.model.selection;

import no.dervis.yatzy.Util;
import no.dervis.yatzy.model.Category;

import java.util.List;
import java.util.Optional;

public class MinValueSelection extends AbstractSelection {

    public MinValueSelection() {
        super();
    }

    public MinValueSelection(SelectionParams selectionParams) {
        super(selectionParams);
    }

    @Override
    public Optional<Category> select() {
        Integer max = Util.min(getDiceList());

        Category category = Category.fromIndex(max);
        if (!getCategoryList().contains(category)) return Optional.of(category);

        List<Integer> notTaken = selectionParams.getScoreCard().selectableValues(getDiceList());

        // the currently available categories is not among the dice we got
        if (notTaken.isEmpty()) return Optional.empty();

        Integer nextMax = Util.min(notTaken);
        return Optional.of(Category.fromIndex(nextMax));
    }
}
