package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PairCategory extends Category implements ICategoryService {

    public PairCategory() {
        name = "PairCategory";
    }

    @Override
    public long score(DiceRoll diceRoll) {
        int pairValue = diceRoll.getElements().stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(Map.Entry::getKey)
            .max()
            .orElse(0);
        return pairValue >= 2 ? pairValue * 2 : 0;
    }
}
