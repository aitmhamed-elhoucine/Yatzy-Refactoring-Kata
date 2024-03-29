package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

public class SideCategory extends Category implements ICategoryService {
    private final int sideNumber;

    public SideCategory(int sideNumber) {
        this.sideNumber = sideNumber;
    }

    @Override
    public long score(DiceRoll diceRoll) {
        return diceRoll.getElements().stream().filter(die -> die == sideNumber).mapToInt(Integer::intValue).sum();
    }
}
