package no.dervis.yatzy.model.selection;

import no.dervis.yatzy.model.Category;

import java.util.Optional;

public interface Selection {

    /**
     * Given a set of dice, select a category.
     *
     * @return A Category enum.
     */
    Optional<Category> select();

}
