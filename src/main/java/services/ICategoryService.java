package services;

import entities.DiceRoll;
import services.Impl.*;

import java.util.ArrayList;
import java.util.List;

public interface ICategoryService {
    long score(DiceRoll diceRoll);

    static List<ICategoryService> getAvailableCategories() {
        List<ICategoryService> categories = new ArrayList<>();
        categories.add(new ChanceCategory());
        categories.add(new YatzyCategory());
        categories.add(new SideCategory(1));
        categories.add(new SideCategory(2));
        categories.add(new SideCategory(3));
        categories.add(new SideCategory(4));
        categories.add(new SideCategory(5));
        categories.add(new SideCategory(6));
        categories.add(new PairCategory());
        categories.add(new TwoPairsCategory());
        categories.add(new NumberOfAKindCategory(3));
        categories.add(new NumberOfAKindCategory(4));
        categories.add(new SmallStraightCategory());
        categories.add(new LargeStraightCategory());
        categories.add(new FullHouseCategory());
        return categories;
    }

}
