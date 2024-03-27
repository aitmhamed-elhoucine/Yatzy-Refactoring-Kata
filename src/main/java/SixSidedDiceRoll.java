import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SixSidedDiceRoll {
    private final List<Integer> sixSidedDiceRoll;

    public SixSidedDiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.sixSidedDiceRoll = Arrays.asList(d1, d2, d3, d4, d5);
    }

    protected int scoreSide(int sideNumber) {
        return this.sixSidedDiceRoll.stream().filter(die -> die == sideNumber).mapToInt(Integer::intValue).sum();
    }

    protected int sum() {
        return this.sixSidedDiceRoll.stream().mapToInt(Integer::intValue).sum();
    }

    protected Map<Integer, Long> countOccurrences() {
        return this.sixSidedDiceRoll.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    protected int countDistinct() {
        return (int) this.sixSidedDiceRoll.stream().distinct().count();
    }

    protected int calculateKindScore(int numDiceRequired) {
        return this.sixSidedDiceRoll.stream()
            .sorted(Comparator.reverseOrder())
            .filter(die -> this.sixSidedDiceRoll.stream().filter(currentDie -> Objects.equals(currentDie, die)).count() >= numDiceRequired)
            .findFirst().map(die -> die * numDiceRequired)
            .orElse(Yatzy.ZERO_SCORE);
    }

    protected int calculateStraight(List<Integer> expectedValues, int score) {
        Collections.sort(this.sixSidedDiceRoll);
        return this.sixSidedDiceRoll.equals(expectedValues) ? score: Yatzy.ZERO_SCORE;
    }

}
