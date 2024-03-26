import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Yatzy {

    private static final int YATZY_SCORE = 50;
    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;

    private static final int ZERO_SCORE = 0;

    /**
     * The player scores the sum of all dice, no matter what they read
     */
    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    /**
     * Calculates the score for Yatzy.
     * Yatzy scores 50 points if all dice have the same number.
     */
    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        if (Arrays.stream(dice).distinct().count() == 1) {
            return YATZY_SCORE;
        }
        return ZERO_SCORE;
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read one.
     */
    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return (int) Arrays.stream(dice).filter(die -> die == 1).count();
    }

    /**
     * Calculates the score for twos.
     * The player scores the sum of the dice that read two.
     */
    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).filter(die -> die == 2).map(die -> 2).sum();
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read three.
     */
    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).filter(die -> die == 3).map(die -> 3).sum();
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read four.
     */
    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).filter(die -> die == 4).map(die -> 4).sum();
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read five.
     */
    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).filter(die -> die == 5).map(die -> 5).sum();
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read six.
     */
    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).filter(die -> die == 6).map(die -> 6).sum();
    }

    /**
     * Calculates the score for pair.
     * The player scores the sum of the two highest matching dice.
     */
    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(d1, counts.getOrDefault(d1, 0) + 1);
        counts.put(d2, counts.getOrDefault(d2, 0) + 1);
        counts.put(d3, counts.getOrDefault(d3, 0) + 1);
        counts.put(d4, counts.getOrDefault(d4, 0) + 1);
        counts.put(d5, counts.getOrDefault(d5, 0) + 1);

        int pairValue = counts.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(Map.Entry::getKey)
            .max()
            .orElse(0);

        return pairValue >= 2 ? pairValue * 2 : ZERO_SCORE;
    }

    /**
     * Calculates the score for two pairs.
     * If there are two pairs of dice with the same number, the player scores the sum of these dice.
     */
    public static int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(d1, counts.getOrDefault(d1, 0) + 1);
        counts.put(d2, counts.getOrDefault(d2, 0) + 1);
        counts.put(d3, counts.getOrDefault(d3, 0) + 1);
        counts.put(d4, counts.getOrDefault(d4, 0) + 1);
        counts.put(d5, counts.getOrDefault(d5, 0) + 1);

        int numPairs = 0;
        int score = 0;
        for (int i = 1; i <= 6; i++) {
            if (counts.getOrDefault(i, 0) >= 2) {
                numPairs++;
                score += i * 2;
            }
        }
        return numPairs == 2 ? score : ZERO_SCORE;
    }

    /**
     * Calculates the score for three of a kind.
     * If there are three dice with the same number, the player scores the sum of these dice.
     */
    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).boxed()
            .sorted(Comparator.reverseOrder())
            .filter(die -> Arrays.stream(dice).filter(currentDie -> currentDie == die).count() >= 3)
            .findFirst().map(die -> die * 3)
            .orElse(0);
    }

    /**
     * Calculates the score for four of a kind.
     * If there are four dice with the same number, the player scores the sum of these dice.
     */
    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return Arrays.stream(dice).boxed()
            .sorted(Comparator.reverseOrder())
            .filter(die -> Arrays.stream(dice).filter(currentDie -> currentDie == die).count() >= 4)
            .findFirst().map(die -> die * 4)
            .orElse(ZERO_SCORE);
    }


    /**
     * Calculates the score for large straight.
     * When placed on "large straight", if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     */
    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};

        Arrays.sort(dice);

        if (Arrays.equals(dice, new int[]{1,2, 3, 4, 5})) {
            return SMALL_STRAIGHT_SCORE;
        }

        return ZERO_SCORE;
    }

    /**
     * Calculates the score for large straight.
     * When placed on "large straight", if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     */
    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};

        Arrays.sort(dice);

        if (Arrays.equals(dice, new int[]{2, 3, 4, 5, 6})) {
            return LARGE_STRAIGHT_SCORE;
        }
        return ZERO_SCORE;
    }

    /**
     * Calculates the score for full house.
     * If the dice are two of a kind and three of a kind, the player scores the sum of all the dice.
     */
    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;

        // Check for two of a kind and three of a kind
        boolean twoOfAKind = false;
        boolean threeOfAKind = false;
        int twoOfAKindValue = 0;
        int threeOfAKindValue = 0;

        for (int i = 0; i < 6; i++) {
            if (tallies[i] == 2) {
                twoOfAKind = true;
                twoOfAKindValue = i + 1;
            } else if (tallies[i] == 3) {
                threeOfAKind = true;
                threeOfAKindValue = i + 1;
            }
        }

        // If both two of a kind and three of a kind are present, calculate the score
        if (twoOfAKind && threeOfAKind) {
            //int sum = Arrays.stream(new int[]{d1, d2, d3, d4, d5}).sum();
            return (twoOfAKindValue * 2) + (threeOfAKindValue * 3);
        } else {
            return ZERO_SCORE;
        }
    }
}



