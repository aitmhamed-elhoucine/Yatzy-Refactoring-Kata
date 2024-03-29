package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoPairsCategory extends Category implements ICategoryService {

    public TwoPairsCategory() {
        name = "TwoPairsCategory";
    }

    @Override
    public long score(DiceRoll diceRoll) {
        int numPairs = 0;
        int score = 0;
        for (int i = 1; i <= 6; i++) {
            if (diceRoll.getElements().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .getOrDefault(i, 0L) >= 2) {
                numPairs++;
                score += i * 2;
            }
        }
        return numPairs == 2 ? score : 0;
    }
}
