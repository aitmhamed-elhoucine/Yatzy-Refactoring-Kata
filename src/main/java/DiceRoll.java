import java.util.*;

public class DiceRoll {
    private final List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    protected int countDice(int diceNum) {
        return this.dice.stream().filter(die -> die == diceNum).mapToInt(Integer::intValue).sum();
    }

    protected int sum() {
        return this.dice.stream().mapToInt(Integer::intValue).sum();
    }

    protected Map<Integer, Integer> countOccurrences() {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(this.dice.get(0), counts.getOrDefault(this.dice.get(0), 0) + 1);
        counts.put(this.dice.get(1), counts.getOrDefault(this.dice.get(1), 0) + 1);
        counts.put(this.dice.get(2), counts.getOrDefault(this.dice.get(2), 0) + 1);
        counts.put(this.dice.get(3), counts.getOrDefault(this.dice.get(3), 0) + 1);
        counts.put(this.dice.get(4), counts.getOrDefault(this.dice.get(4), 0) + 1);
        return  counts;
    }

    protected int countDistinct() {
        return (int) this.dice.stream().distinct().count();
    }

    protected int calculateKindScore(int numDiceRequired) {
        return this.dice.stream()
            .sorted(Comparator.reverseOrder())
            .filter(die -> this.dice.stream().filter(currentDie -> Objects.equals(currentDie, die)).count() >= numDiceRequired)
            .findFirst().map(die -> die * numDiceRequired)
            .orElse(Yatzy.ZERO_SCORE);
    }

    protected int calculateStraight(List<Integer> expectedValues, int score) {
        Collections.sort(this.dice);
        return this.dice.equals(expectedValues) ? score: Yatzy.ZERO_SCORE;
    }
}
