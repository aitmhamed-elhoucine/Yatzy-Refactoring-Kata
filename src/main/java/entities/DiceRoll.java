package entities;

import java.util.*;

public class DiceRoll {
    private final List<Integer> elements;

    public List<Integer> getElements() {
        return elements;
    }

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.elements = Arrays.asList(d1, d2, d3, d4, d5);
    }

    @Override
    public String toString() {
        return "DiceRoll{" +
            "elements=" + elements +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiceRoll diceRoll = (DiceRoll) o;
        return Objects.equals(elements, diceRoll.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

}
