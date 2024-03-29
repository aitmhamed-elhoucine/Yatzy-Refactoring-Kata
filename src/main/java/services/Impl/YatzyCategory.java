package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

public class YatzyCategory extends Category implements ICategoryService {

    private static final int YATZY_SCORE = 50;
    @Override
    public long score(DiceRoll diceRoll) {
        if (diceRoll.getElements().stream().distinct().count() == 1) {
            return YATZY_SCORE;
        }
        return 0;
    }
}
