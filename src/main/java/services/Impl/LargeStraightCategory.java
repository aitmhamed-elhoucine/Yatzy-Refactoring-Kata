package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

import java.util.Collections;
import java.util.List;

public class LargeStraightCategory extends Category implements ICategoryService {

    private static final List<Integer> LARGE_STRAIGHT_LIST = List.of(2,3,4,5,6);;
    private static final int LARGE_STRAIGHT_SCORE = 20;

    public LargeStraightCategory() {
        name = "LargeStraightCategory";
    }

    @Override
    public long score(DiceRoll diceRoll) {
        Collections.sort(diceRoll.getElements());
        return diceRoll.getElements().equals(LARGE_STRAIGHT_LIST) ? LARGE_STRAIGHT_SCORE: 0;
    }
}
