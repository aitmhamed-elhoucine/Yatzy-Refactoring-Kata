package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

public class ChanceCategory extends Category implements ICategoryService {
    @Override
    public long score(DiceRoll diceRoll) {
        return diceRoll.getElements().stream().mapToInt(Integer::intValue).sum();
    }
}
