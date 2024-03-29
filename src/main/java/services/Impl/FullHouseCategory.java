package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

public class FullHouseCategory extends Category implements ICategoryService {

    public FullHouseCategory() {
        name = "FullHouseCategory";
    }

    @Override
    public long score(DiceRoll diceRoll) {
        return new PairCategory().score(diceRoll) != 0
            && new NumberOfAKindCategory(3).score(diceRoll) != 0
            && new YatzyCategory().score(diceRoll) == 0  ? new ChanceCategory().score(diceRoll) : 0;

    }
}
