package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

import java.util.Collections;
import java.util.List;

public class SmallStraightCategory extends Category implements ICategoryService {

    private static final List<Integer> SMALL_STRAIGHT_LIST = List.of(1,2,3,4,5);
    private static final int SMALL_STRAIGHT_SCORE = 15;

    public SmallStraightCategory() {
        name = "SmallStraightCategory";
    }

    @Override
    public long score(DiceRoll diceRoll) {
        Collections.sort(diceRoll.getElements());
        return diceRoll.getElements().equals(SMALL_STRAIGHT_LIST) ? SMALL_STRAIGHT_SCORE: 0;
    }
}
