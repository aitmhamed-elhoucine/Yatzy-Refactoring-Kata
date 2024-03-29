package services.Impl;

import entities.Category;
import services.ICategoryService;
import entities.DiceRoll;

import java.util.Comparator;
import java.util.Objects;

public class NumberOfAKindCategory extends Category implements ICategoryService {
    private final int numberOfAKind;

    public NumberOfAKindCategory(int numberOfAKind) {
        this.numberOfAKind = numberOfAKind;
    }

    @Override
    public long score(DiceRoll diceRoll) {
        return diceRoll.getElements().stream()
            .sorted(Comparator.reverseOrder())
            .filter(die -> diceRoll.getElements().stream().filter(currentDie -> Objects.equals(currentDie, die)).count() >= numberOfAKind)
            .findFirst().map(die -> die * numberOfAKind)
            .orElse(0);
    }
}
